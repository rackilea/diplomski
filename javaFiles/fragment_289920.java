package com.phonegap.plugins.serialhelper;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.*;


public class SerialHelper extends CordovaPlugin
{

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if ("getFableSerial".equals(action)) {
            String serial = "15345344132354";
            callbackContext.success(serial);
            //callbackContext.sendPluginResult(new PluginResult(Status.OK, serial));
            return true;
        }
        else{
            callbackContext.error("method not found");
            return false;
        }
    }
}