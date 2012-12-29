package com.twofours.surespot;

import java.security.Security;

import android.app.Application;
import android.content.Context;

import com.twofours.surespot.chat.ChatController;
import com.twofours.surespot.encryption.EncryptionController;
import com.twofours.surespot.network.NetworkController;

public class SurespotApplication extends Application {
    private static Context context;
    private static EncryptionController encryptionController;
    private static ChatController chatController;
    private static NetworkController networkController;

    public void onCreate(){
        super.onCreate();
        
        Security.addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());
        
        SurespotApplication.context = getApplicationContext();
        
        //create controllers
        encryptionController = new EncryptionController();
        chatController = new ChatController();
        networkController = new NetworkController();
        
    }

    public static Context getAppContext() {    	
        return SurespotApplication.context;
    }
	
    public static EncryptionController getEncryptionController() { 
    	return encryptionController;
    }
    
    public static ChatController getChatController() {
    	return chatController;
    }
    
    public static NetworkController getNetworkController() {
    	return networkController;
    }
	
}
