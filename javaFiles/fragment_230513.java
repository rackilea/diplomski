@Override
public void onCreate() {
    super.onCreate();
    // initialize wifi instace here
    wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
    //....your code here...    
}