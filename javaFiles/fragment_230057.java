private final MyDateChangeReceiver mDateReceiver = new MyDateChangeReceiver();

public class MyDateChangeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {

        // compare current time and decide if it's 12 AM
        Log.d("MyDateChangeReceiver", "Time changed");

    }
}