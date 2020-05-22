final BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {

       //Action to perform when notification is dismissed
       if (intent.hasExtra("NOTIFICATION_ID") {
           int id = intent.getIntExtra("NOTIFICATION_ID", -1);
           // Use Id
       }

        unregisterReceiver(this);
    }
};