WifiConfiguration wc = new WifiConfiguration();
wc.SSID = "some ssid from the list";
wc.status = WifiConfiguration.Status.ENABLED;
wc.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);

WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
int networkId = wifi.addNetwork(wc);
if (networkId == -1) {
    // probably not open
} else {
    // likely open
}