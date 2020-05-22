BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Broadcast","broadcast received");
        String value = intent.getStringExtra("Variable"); // this will get the value 
                                                          // send from Service
    }
};