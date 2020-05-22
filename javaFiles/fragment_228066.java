@Override
public void onCreate(Bundle savedInstanceState) {

  ...

  // Every time a button is clicked, we want to broadcast a notification.
  findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      sendMessage();
    }
  });
}

// Send an Intent with an action named "custom-event-name". The Intent sent should 
// be received by the ReceiverActivity.
private void sendMessage() {
  Log.d("sender", "Broadcasting message");
  Intent intent = new Intent("custom-event-name");
  // You can also include some extra data.
  intent.putExtra("message", "This is my message!");
  LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}