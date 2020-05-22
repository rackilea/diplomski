//receiver class
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Activity activity = (Activity) context;
        ((MainApplication)activity.getApplication()).myMethod();
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
    }
}