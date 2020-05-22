@Override
public void onReceive(Context arg0, Intent arg1) 
{
    final String[] blabla = new String[] { "blabla" };
    Handler connectionStatusHandler = new Handler() 
    {
        @Override
        public void handleMessage(Message msg) 
        {
            blabla[0] = "new string value";
        }

    };
    blabla[0] = "i'm still editable";
}