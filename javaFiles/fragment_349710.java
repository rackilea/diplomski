public class ConnectivityReceiver extends WakefulBroadcastReceiver {
private static final String TAG = ConnectivityReceiver.class.getSimpleName();

@Override
public void onReceive(Context context, Intent intent) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
        Log.d(TAG, "network state change; new state: connected");
    } else {
        Log.d(TAG, "network state change; new state: " + (cm.getActiveNetworkInfo() != null ? cm.getActiveNetworkInfo().getState() : " unknown"));
    }
}