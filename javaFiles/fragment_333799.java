public class InternetStatusListener extends BroadcastReceiver {
private static final String TAG="INTERNET_STATUS";
@Override
public void onReceive(Context context, Intent intent) {
    Log.e(TAG, "network status changed");
    if(InternetStatusListener.isOnline(context)){//check if the device has an Internet connection
        //Start a service that will make your TCP Connection.

    }
}
}
  public static boolean isOnline(Context context) {
    ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
        return true;
    }
    return false;
}