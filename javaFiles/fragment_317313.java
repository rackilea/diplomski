public class MyAlarm extends BroadcastReceiver {
    public void onReceive(final Context context, Intent intent) {

        int interval = intent.getIntExtra("Interval", 0) // Get "interval" value here

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                //do some stuff
            }
        }, interval * 60000); // Use "interval" here
    }
}