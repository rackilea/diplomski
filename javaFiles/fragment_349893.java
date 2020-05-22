public class ConnectivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();
        if(intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
                if(netInfo.isConnected()) {
                    WifiManager wifiManager = (WifiManager) context.getAplicationContext().getSystemService (Context.WIFI_SERVICE);
                    WifiInfo info = wifiManager.getConnectionInfo ();
                    String ssid  = info.getSSID();
                    Log.d("Wifi Connected", "Wifi name is "+ info.getSSID());
                }
        }
    }
}