BufferedWriter writer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    writer = new BufferedWriter(new FileWriter("mnt/sdcard/gps.txt"));
    //...

}

@Override
protected void onResume() {
    super.onResume();
    if(broadcastReceiver == null){
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                textView.append("\n" +intent.getExtras().get("coordinates"));

                writer.write(intent.getExtras().get("coordinates"));
                writer.newLine();

            }
        };
    }
    registerReceiver(broadcastReceiver,new IntentFilter("location_update"));
}

protected void onDestroy() {
    super.onDestroy();
    writer.close();
    if(broadcastReceiver != null){
        unregisterReceiver(broadcastReceiver);
    }
}