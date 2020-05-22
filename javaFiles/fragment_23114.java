BroadcastReceiver myReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ActivityA", "finishing A");
        finish();
    }
};

@Override
protected void onDestroy() {
    unregisterReceiver(myReceiver);
    super.onDestroy();
} // This is mandatory to unregister the receiver, else error occur