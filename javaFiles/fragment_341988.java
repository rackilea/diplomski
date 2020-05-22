public static final String NETWORK_STATE_CHANGED = "yourpackagename.action.networkStateChanged";

private WebView mWebView;

private LocalBroadcastManager mBroadcastManager;
private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
  @Override
  public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals(NETWORK_STATE_CHANGED)) {
      // Here is your logic for loading the real page.
      mWebView.loadUrl("http://xxxx.xxxx.xx.xx/xxxxx/#/?h=" + xxx + "&location=" + locationName);
    }
  }
};

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.your_xml);
  mWebView = (WebView) findViewById(R.id.your_webview_id);
  mBroadcastManager = LocalBroadcastManager.getInstance(this);
  IntentFilter intentFilter = new IntentFilter();
  intentFilter.addAction(NETWORK_STATE_CHANGED);
  mBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);
}

@Override
protected void onDestroy() {
  super.onDestroy();
  mBroadcastManager.unregisterReceiver(mBroadcastReceiver);
}