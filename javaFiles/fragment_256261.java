@Override
protected void onDestroy() {
    super.onDestroy();
    if(broadcastReceiver!=null)
    {
        unregisterReceiver(broadcastReceiver);
    }

}