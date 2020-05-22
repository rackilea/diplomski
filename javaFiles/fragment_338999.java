public class NetworkStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
     Log.d("app","Network connectivity change");
     if(intent.getExtras()!=null) {
        NetworkInfo ni=(NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
        if(ni!=null && ni.getState()==NetworkInfo.State.CONNECTED) {
            Log.i("app","Network "+ni.getTypeName()+" connected");
        }
     }
     if(intent.getExtras().getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY,Boolean.FALSE)) {
            Log.d("app","There's no network connectivity");
     }
   }
}