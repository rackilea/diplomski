public class MainActivity extends Activity {

    private HeadsetBroadcastReceiver mHeadsetBroadcastReceiver;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myReceiver = new HeadsetBroadcastReceiver();
    }

    @Override 
    protected void onResume() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(mHeadsetBroadcastReceiver, filter);
        super.onResume();
    }

    @Override 
    protected void onPause() {
        unregisterReceiver(mHeadsetBroadcastReceiver);
        super.onPause();
    }

    private class HeadsetBroadcastReceiver extends BroadcastReceiver {
        @Override 
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                int state = intent.getIntExtra("state", -1);

                if (state == 0) {
                    //Headset is unplugged
                } else if(state == 1) {
                    //Headset is plugged
                }
            }
        }
    }
}