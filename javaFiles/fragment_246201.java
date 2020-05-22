Handler handler = new Handler()
{
    public void handleMessage(Message msg)
    {

        String dataString = "";

        Bundle bundle = msg.getData();

        Log.d("handleMessage", bundle.toString());
        if (bundle.containsKey("outgoingString"))
        {
            dataString = bundle.getString("outgoingString");

        }

        // you can handle other message types here....
   }