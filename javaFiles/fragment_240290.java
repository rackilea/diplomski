public class AlarmReciever extends BroadcastReceiver
    {
             @Override
                public void onReceive(Context context, Intent intent)
                {
                     Intent serviceIntent = new Intent(context,
                             NotifyIntentService.class); 
                       startService(serviceIntent);
                 }

    }