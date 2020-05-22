package com.example.gcmdemo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMConstants;

public class GCMIntentService extends GCMBaseIntentService {

     private static final String TAG = "Push Notification Demo GCMIntentService";

    @Override
    protected void onError(Context context, String errorId) {

        if(GCMConstants.ERROR_ACCOUNT_MISSING.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Account Missing");
        } else if(GCMConstants.ERROR_AUTHENTICATION_FAILED.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Authentication Failed");
        } else if(GCMConstants.ERROR_INVALID_PARAMETERS.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Invalid Parameters");
        } else if(GCMConstants.ERROR_INVALID_SENDER.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Invalid Sender");
        } else if(GCMConstants.ERROR_PHONE_REGISTRATION_ERROR.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Phone Registration Error");
        } else if(GCMConstants.ERROR_SERVICE_NOT_AVAILABLE.equalsIgnoreCase(errorId)) {
            Log.v(TAG, "Error Service Not Available");
        } 
    }

    @Override
    protected void onMessage(Context context, Intent intent) {

        // App Server Sends message as key value pairs 
        String value1 = intent.getStringExtra("key1");
        String value2 = intent.getStringExtra("key2");

        Log.v(TAG, "key1: "+value1 );
        Log.v(TAG, "key2: "+value2 );
    }

    @Override
    protected void onRegistered(Context context, String regId) {

        Log.v(TAG, "Successfull Registration : "+regId);
    }

    @Override
    protected void onUnregistered(Context context, String regId) {

        Log.v(TAG, "Successfully Unregistred : "+regId);
    }

    @Override
    protected String[] getSenderIds(Context context) {
        return super.getSenderIds(context);
    }

    @Override
    protected void onDeletedMessages(Context context, int total) {
        super.onDeletedMessages(context, total);
    }

    @Override
    protected boolean onRecoverableError(Context context, String errorId) {
        return super.onRecoverableError(context, errorId);
    }
}