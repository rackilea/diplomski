ConnectivityManager connManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
NetworkInfo wifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

if (wifi.isConnected()){
    // If Wi-Fi connected
}else{
    Toast.makeText(getApplicationContext() /*Context field*/,"Please Connect to Wifi",Toast.LENGTH_SHORT).show();
}