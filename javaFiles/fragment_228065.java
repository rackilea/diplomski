@Override
public void onCreate(Bundle savedInstanceState) {

  ...

  // Register to receive messages.
  // We are registering an observer (mMessageReceiver) to receive Intents
  // with actions named "custom-event-name".
  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
      new IntentFilter("custom-event-name"));
}

// Our handler for received Intents. This will be called whenever an Intent
// with an action named "custom-event-name" is broadcasted.
private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
  @Override
  public void onReceive(Context context, Intent intent) {
    // Get extra data included in the Intent
    String message = intent.getStringExtra("message");
    Log.d("receiver", "Got message: " + message);
  }
};

@Override
protected void onDestroy() {
  // Unregister since the activity is about to be closed.
  LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
  super.onDestroy();
}