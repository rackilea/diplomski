private static final String ACTION_GPS = "android.location.PROVIDERS_CHANGED";
private BroadcastReceiver yourReceiver;

@Override
public void onStop() {
    super.onStop();
    // Do not forget to unregister the receiver!!!
    if (yourReceiver != null) {
        unregisterReceiver(yourReceiver);
        yourReceiver = null;
    }

@Override
public void onResume() {
    super.onResume();
    registerReceiverGPS();



private void registerReceiverGPS() {
    if (yourReceiver == null) {
        // INTENT FILTER FOR GPS MONITORING
        final IntentFilter theFilter = new IntentFilter();
        theFilter.addAction(ACTION_GPS);
        yourReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String s = intent.getAction();
                    if (s != null) {
                        if (s.equals(ACTION_GPS)) {
                            checkGPS();
                        }
                    }
                }
            }
        };
        registerReceiver(yourReceiver, theFilter);
    }
}


 private void checkGPS() {
    Context context = this.getApplicationContext();
    if (context != null) {
        Button btnGPS = (Button) findViewById(R.id.btnGPS);
        if (btnGPS != null) {
            LocationManager locationManager = (LocationManager) context
                    .getSystemService(Context.LOCATION_SERVICE);
            boolean b = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            locationManager = null;
            if (b) {
                if (btnGPS.getVisibility() != View.GONE) {
                    btnGPS.setVisibility(View.GONE);
                }
            } else {
                if (btnGPS.getVisibility() != View.VISIBLE) {
                    btnGPS.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}