protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);    
    setContentView(R.layout.activity_home_frame);

  IntentFilter filter = new IntentFilter();
  filter.addAction("LOCATION_CHANGE"); 

  mReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {

      String latitude = intent.getExtras().getString("LATITUDE");
      String longitude= intent.getExtras().getString("LONGITUDE");
    }
  };
    LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, filter);
}