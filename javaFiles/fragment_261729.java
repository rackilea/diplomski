@Override
public boolean execute(String action, JSONArray data, String callbackId)  throws JSONException {
        if (action.equals("start")) {

              start();
        } else {
            PluginResult pluginResult = new PluginResult(PluginResult.Status.INVALID_ACTION);
            callbackContext.sendPluginResult(pluginResult);
            return false;
        }
}


    private boolean start() throws JSONException {

        MyClass.startProcess(new MyInterface() {

            @Override
            public void onSuccess(String data) {

                PluginResult result = new PluginResult(PluginResult.Status.OK, data);
                result.setKeepCallback(false);
                callbackContext.sendPluginResult(result);
            }

            @Override
            public void onFail() {

                PluginResult result = new PluginResult(PluginResult.Status.ERROR);
                result.setKeepCallback(false);
                callbackContext.sendPluginResult(result);
            }

        });

    PluginResult.Status status = PluginResult.Status.NO_RESULT;

    PluginResult pluginResult = new PluginResult(status);
    pluginResult.setKeepCallback(true);
    callbackContext.sendPluginResult(pluginResult);
    return true;

    }