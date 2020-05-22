public boolean execute(String action, JSONArray args,
            CallbackContext callbackContext) throws JSONException
    {

    PluginResult r = new PluginResult(PluginResult.Status.NO_RESULT);
    r.setKeepCallback(true);
    callbackContext.sendPluginResult(r);

    Intent i = new Intent(context, Signature.class);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    cordova.startActivityForResult(this,i,90);

    return true;

}

public void onActivityResult(int requestCode, int resultCode, Intent intent){
    // here is your former code
    ...
    ...
    // at last call sendPluginResult 
    this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result.toString()));

    // when there is no direct result form your execute-method use sendPluginResult because most plugins I saw and made recently (Reminder) prefer sendPluginResult to success/error
    // this.callbackContext.success(result.toString());
}