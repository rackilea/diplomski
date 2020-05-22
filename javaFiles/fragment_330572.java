@Override
public IBinder onBind(Intent intent)
{
    if (intent.getAction().equals("custom_intent"))
    {
        return customBinder;
    }
    else
    {
        return super.onBind(intent);
    }
}