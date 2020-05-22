class Net { 
    public boolean isWifiEnabled(Context context) { 
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifi.isWifiEnabled();
    } 
}