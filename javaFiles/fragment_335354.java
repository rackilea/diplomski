public class WifiHelper extends BroadcastReceiver {
    @RootContext
    Context context;

    @SystemService
    ConnectivityManager connectivityManager;

    @SystemService
    WifiManager wifiManager;

    // For API>=21
    private WifiHelperNetworkCallback wnc;

    // For API<21
    private boolean isBroadcastRegistered;

    private String desiredSSID;

    private Runnable callback;

    public void enableNetwork(String ssid, int networkId, Runnable callback) {
        desiredSSID = ssid;
        wifiManager.enableNetwork(networkId, true);
        configureNetworkRequest();
    }

    private void networkAvailable() {
        // this method will be called when the network is available
        callback.run();
    }

    private void configureNetworkRequest() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            configureNetworkRequestAPI21();
        } else {
            configureNetworkRequestLegacy();
        }
    }

    @TargetApi(21)
    private void configureNetworkRequestAPI21() {
        NetworkRequest request = new NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build();
        if (wnc == null) wnc = new WifiHelperNetworkCallback(this, connectivityManager);

        connectivityManager.requestNetwork(request, wnc);
    }

    private void configureNetworkRequestLegacy() {
        unregisterReceiver();

        connectivityManager.startUsingNetworkFeature(ConnectivityManager.TYPE_WIFI, null);
        IntentFilter intent = new IntentFilter();
        intent.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intent.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);

        context.registerReceiver(this, intent);
        isBroadcastRegistered = true;
    }

    @TargetApi(21)
    private void disableNetworkRequest() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            if (wnc != null) connectivityManager.unregisterNetworkCallback(wnc);

            ConnectivityManager.setProcessDefaultNetwork(null);
        } else {
            unregisterReceiver();
        }
    }

    private void unregisterReceiver() {
        if (isBroadcastRegistered) {
            context.unregisterReceiver(this);
            isBroadcastRegistered = false;
        }
    }

    // API<21
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo networkInfo =
                    intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if(networkInfo.isConnected()) {
                // Wifi is connected

                if (desiredSSID.equals(getCurrentSSID())) {
                    // Callback and unregister
                    networkAvailable();
                    unregisterReceiver();
                }
            }
        }
    }

    public String getCurrentSSID() {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo != null && wifiInfo.getSupplicantState()== SupplicantState.COMPLETED) {
            return ssidWithoutQuotes(wifiInfo.getSSID());
        }
        else return null;
    }

    protected static String ssidWithoutQuotes(String ssid) {
        if (ssid == null) return null;
        else if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            return ssid.substring(1, ssid.length() - 1);
        } else {
            return ssid;
        }
    }

    protected String getDesiredSSID() {
        return desiredSSID;
    }

    @TargetApi(21)
    public static class WifiHelperNetworkCallback extends ConnectivityManager.NetworkCallback {
        public final String LOG_TAG = WifiHelper.class.getSimpleName();

        private ConnectivityManager connectivityManager;
        private WifiHelper wifiHelper;

        public WifiHelperNetworkCallback(WifiHelper wifiHelper, ConnectivityManager connectivityManager) {
            this.wifiHelper = wifiHelper;
            this.connectivityManager = connectivityManager;
        }

        public void onAvailable(Network network) {
            // Do something once the network is available
            NetworkInfo info = connectivityManager.getNetworkInfo(network);;

            Log.i(LOG_TAG, "networkcallback!! " + info.getExtraInfo());

            String desiredSSID = wifiHelper.getDesiredSSID();

            if (desiredSSID != null && desiredSSID.equals(ssidWithoutQuotes(info.getExtraInfo()))) {
                ConnectivityManager.setProcessDefaultNetwork(network);
                wifiHelper.networkAvailable();
            }
        }

    }

}