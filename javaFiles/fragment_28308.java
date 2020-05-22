private BroadcastReceiver mMessageReceiver = new BroadcastReceiver()
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String message = intent.getStringExtra("message");
        Log.d("receiver", "Got message: " + message);

        if (message.equals("eventOne"))
        {
            //do something
        }
        else if (message.equals("eventTwo"))
        {
            //do something else
        }
    }
};