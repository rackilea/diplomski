private BroadcastReceiver mMyServiceUpdateReciever;
...

@Override
public void onResume() {
    super.onResume();
    mMyServiceUpdateReciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                onUpdateMethod();
            }
        };
    LocalBroadcastManager.getInstance(this).registerReceiver(mMyServiceUpdateReciever, new IntentFilter(MyService.ACTION_UPDATE));
}

@Override
public void onPause() {
    super.onPause();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mMyServiceUpdateReciever);
}