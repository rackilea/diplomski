ConnectivityManager cm =
        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    //if there is a connection
    if (netInfo != null && netInfo.isConnectedOrConnecting()){
     ...put your code here...
}