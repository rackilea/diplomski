public class MainActivity extends AppCompatActivity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mBroadcastReceiver, new IntentFilter("webview-filter"));
        ...
    }
    ...
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mv.loadUrl("javascript: loadMainData ()");
        }
    };
    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
        super.onDestroy();
    }
}