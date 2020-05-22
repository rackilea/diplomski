@Override
protected void onPause() {
    super.onPause();
    unregisterReceiver(networkReceiver);
}

@Override
protected void onResume() {
    super.onResume();
    IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    registerReceiver(networkReceiver, filter);
}