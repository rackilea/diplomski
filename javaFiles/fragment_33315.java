private boolean notConnectedToWifi(){
    final ConnectivityManager conMgr = (ConnectivityManager).getSystemService(Context.CONNECTIVITY_SERVICE);
    final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
    if (activeNetwork != null && activeNetwork.isConnected() && activeNetwork.getType() != ConnectivityManager.TYPE_WIFI) 
        return true;
    else
        return false;

}