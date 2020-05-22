NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
if (networkInfo.isConnected()) {
WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
WifiInfo wifiInfo = wifiMgr.getConnectionInfo();

int ip = wifiInfo.getIpAddress();
int speed = wifiInfo.getLinkSpeed();
speedString = Integer.toString(speed);
mac = wifiInfo.getMacAddress();
ssid = wifiInfo.getSSID();
ipAddress = Formatter.formatIpAddress(ip);
}