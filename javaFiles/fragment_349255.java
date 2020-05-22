private BroadcastReceiver pushMessageBroadCastReceiver;
//here receive the broadcast from Firebase message,then your thing

//add this inside onCreate()
pushMessageBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AppConfig.PUSH_NOTIFICATION)) {

                //Here your receive the data from onMessageReceived()
                //do your thing here
                Log.d("Activity","Is triggerred here")
            }
        }
    };

@Override
protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(pushMessageBroadCastReceiver,
                new IntentFilter(AppConfig.PUSH_NOTIFICATION));
    }

@Override
protected void onPause() {
super.onPause();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(pushMessageBroadCastReceiver);
    }