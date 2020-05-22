public class Autostart extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

           ConnectivityManager connectivityManager = (ConnectivityManager) 
           context.getSystemService(Context.CONNECTIVITY_SERVICE );
           NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
           boolean isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();   
           if (isConnected)       
              // start your service
           }
    }