public class MyReceiver extends BroadcastReceiver
{

@Override
public void onReceive(Context context, Intent intent)
{
    Log.d("INSTA_BOOT : ", "\nBOOT_COMPLETE_EVENT_OF_INSTA....");
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
    {
        context.startForegroundService(new Intent(context, WatchMan.class));
    }
    else
    {
        context.startService(new Intent(context, WatchMan.class));
    }
}
}