@Override
protected void onResume() {
    super.onResume();
    registerReceiver(screenOffReceiver, new IntentFilter(ACTION_SCR_OFF));
}

@Override
protected void onPause() {
    unregisterReceiver(screenOffReceiver);
    super.onPause();
}