@Override
public void onResume() {
    super.onResume();
    LocalBroadcastManager.getInstance(mContext).registerReceiver(mMessageReceiver, new IntentFilter("UI_UPDATE_BROADCAST"));
}


@Override
public void onPause() {
     super.onPause();
     LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mMessageReceiver);
}

private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
     @Override
     public void onReceive(Context context, Intent intent) {
         //Do Something With Received Data
         String msg = intent.getStringExtra("MESSAGE");
     }
};