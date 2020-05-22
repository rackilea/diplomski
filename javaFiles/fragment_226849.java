public class MainActivity1 extends AppCompatActivity {

    public static final String INTENT_FILTER = "do_some_action";
    public static final String INTENT_BUNDLE_VALUE = "value1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);

        LocalBroadcastManager.getInstance(this).registerReceiver(
                mChangeListener, new IntentFilter(INTENT_FILTER));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(mChangeListener);
    }

    private BroadcastReceiver mChangeListener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intentData) {
            // you can do anything here
            if (intentData != null && intentData.hasExtra(INTENT_BUNDLE_VALUE)) {
                String value = intentData.getStringExtra(INTENT_BUNDLE_VALUE);

                doSomeAction(value);
            }
        }
    };
    private void doSomeAction(String value) {

    }
}