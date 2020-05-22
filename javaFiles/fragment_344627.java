public class YourActivity extends Activity {

    //Create broadcast object
    BroadcastReceiver mBroadcast = new BroadcastReceiver() {    
    //When Event is published, onReceive method is called
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.i("[BroadcastReceiver]", "MyReceiver");

        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.d("[BroadcastReceiver]", "Screen ON");
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.d("[BroadcastReceiver]", "Screen OFF");
        }

    }
};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(mBroadcast, new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(mBroadcast, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }
}