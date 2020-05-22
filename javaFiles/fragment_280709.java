@Override
    public void onResume() {
        super.onResume();
       LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter());
        startService(intent);
    }