WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
    if (mWifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
     mWifiManager.getConnectionInfo().getRssi()
     mWifiManager.getConnectionInfo().getSsid()
    }