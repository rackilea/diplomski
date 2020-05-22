public ConnectionChecker() {
    super("connectionchecker");

}

@Override
protected void onHandleIntent(Intent intent) {
    ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED|| connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET).getState()== NetworkInfo.State.CONNECTED)

    {

        Intent data = new Intent();
        data.setAction(MainActivity.Connection.ACTION_RESP);
        data.putExtra("connection", 1);
        sendBroadcast(data);


    }
    else
    {
        Intent data = new Intent();
        data.setAction(MainActivity.Connection.ACTION_RESP);
        data.putExtra("connection", 0 );
        sendBroadcast(data);
    }
}