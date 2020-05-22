@Override
protected void onCreate() {

    ...

    // ---when the SMS has been sent---
    private BroadcastReceiver messageSent; // <- stored as a field
    messageSent = new SentMessage(); 
    registerReceiver(messageSent, new IntentFilter(SMSSender.INTENT_MESSAGE_SENT));

    // ---when the SMS has been delivered---
    private BroadcastReceiver messageDelivered; // <- stored as a field
    messageDelivered = new MessageDelivered();
    registerReceiver(messageDelivered, new IntentFilter(
            SMSSender.INTENT_MESSAGE_DELIVERED));
}

@Override
protected void onDestroy() { // remember to unregister
    unregisterReceiver(messageSent);
    unregisterReceiver(messageDelivered );
}