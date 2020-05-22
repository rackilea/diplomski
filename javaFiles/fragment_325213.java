private BroadcastReceiver networkReceiver = new BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
     super.onReceive(context, intent);
     if(intent.getExtras()!=null) {
        NetworkInfo ni=(NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
        if(ni!=null && ni.getState()==NetworkInfo.State.CONNECTED) {
            // we're connected
        }
     }
     // we're not connected 
   }
}