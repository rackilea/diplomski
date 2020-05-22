WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
List<ScanResult> networkList = wifi.getScanResults();
if (networkList != null) {
    for (ScanResult network : networkList)
    {
        String Capabilities =  network.capabilities;        
        Log.w (TAG, network.SSID + " capabilities : " + Capabilities);
    }
}