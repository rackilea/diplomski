private void sendMessage(String event)
{
    Intent intent = new Intent("my-event");

    intent.putExtra("message", event);
    LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
}

@Override
public int onStartCommand(Intent intent, int flags, int startId)
{
    Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
    sendMessage("eventOne");

    return START_STICKY;
}