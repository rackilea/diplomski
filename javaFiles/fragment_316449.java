@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // ...

    LocalBroadcastManager.getInstance(getApplicationContext())
        .registerReceiver(finishReceiver,
            new IntentFilter(FirebaseMessagingService.ACTION_FINISH));
}

@Override
protected void onDestroy() {
    LocalBroadcastManager.getInstance(getApplicationContext())
        .unregisterReceiver(finishReceiver);
    super.onDestroy();
}