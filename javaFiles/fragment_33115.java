private void registerSMSReceiver()
{
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.provider.Telephony.SMS_RECEIVED");
    registerReceiver(receiver, filter);
}

private void unRegisterSMSReceiver()
{
    unregisterReceiver(receiver);
}