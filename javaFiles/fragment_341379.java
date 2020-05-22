final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
wifiManager.startScan(); // without starting scan, we may never receive any scan results

final IntentFilter filter = new IntentFilter();
filter.addAction(WifiManager.RSSI_CHANGED_ACTION); // you can keep this filter if you want to get fresh results when singnal stregth of the APs was changed
filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);

wifiManager.startScan();

final BroadcastReceiver receiver = new BroadcastReceiver() {
  @Override public void onReceive(Context context, Intent intent) {
    wifiManager.startScan(); // start scan again to get fresh results ASAP
    wifiManager.getScanResults();
  }
};

context.registerReceiver(receiver, filter);

// don't forget to unregister receiver when appropriate
// context.unregisterReceiver(receiver);