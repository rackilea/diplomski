public boolean execute(String action, final JSONArray args,
        final CallbackContext callbackId) throws JSONException {
    IntentFilter wifiFilter = new IntentFilter(
            WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
    cordova.getActivity().registerReceiver(wifiBroadcastReceiver,
            wifiFilter);
    this.callbackContext = callbackId;
    PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
    result.setKeepCallback(true);
    this.callbackContext.sendPluginResult(result);
    return true;
}

public class WifiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
            PluginResult result;
            if (intent.getBooleanExtra(
                    WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {
                Toast.makeText(cordova.getActivity(), "Wifi Connected",
                        Toast.LENGTH_SHORT).show();
                result = new PluginResult(PluginResult.Status.OK,
                        "Wifi Connected");
            } else {
                Toast.makeText(cordova.getActivity(), "Wifi Disconnected",
                        Toast.LENGTH_SHORT).show();
                result = new PluginResult(PluginResult.Status.ERROR,
                        "Wifi Disconnected");
            }

            result.setKeepCallback(false);
            if (callbackContext != null) {
                callbackContext.sendPluginResult(result);
                callbackContext = null;
            }
        }
    }
}