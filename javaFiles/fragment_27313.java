//In my Main File:
IntentFilter startUsingScanResults = new IntentFilter("StartUsingScanResults");
c.registerReceiver(serviceConsume.ScanResultReceiver, startUsingScanResults); 

List<ScanResult> scanResults = Some values; 
Intent intent = new Intent();
intent.setAction("StartUsingScanResults");

intent.putParcelableArrayListExtra("ScanResults", (ArrayList<? extends Parcelable>) scanResults);

Context.sendBroadcast(intent);

// And my broadcast receiver 
   public BroadcastReceiver ScanResultReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle extras = intent.getExtras();
    ArrayList<ScanResult> scanResults = extras.getParcelableArrayList("ScanResults");
}
};