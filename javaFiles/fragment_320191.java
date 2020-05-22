public class PowerConnectionReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();

        if(action.equals(Intent.ACTION_POWER_CONNECTED))
        {
            // Do code here for when power connected
        }
        else if(action.equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            // Do code here for when power disconnected
        }
 }