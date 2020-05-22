public String getCurrentSsid(Context context) {
    String ssid = null;
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
    if (networkInfo == null) {
        return null;
    }

    if (networkInfo.isConnected()) {
        final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null && !StringUtil.isBlank(connectionInfo.getSSID())) {
            ssid = connectionInfo.getSSID();
        }
    }
    return ssid;
}