@Override
protected void onResume()
{
    super.onResume();

    LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
            new IntentFilter("my-event"));
}

@Override
protected void onDestroy()
{
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);

    super.onDestroy();
}