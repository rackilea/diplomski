public class WatchMan extends Service
{
NotificationManager mNotifyManager;
NotificationCompat.Builder mBuilder;
NotificationChannel notificationChannel;
String NOTIFICATION_CHANNEL_ID = "17";
private boolean running;

private BroadcastReceiver mCallBroadcastReceiver = new BroadcastReceiver()
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String PhoneNumber = "UNKNOWN";
        Log.d("RECEIVER :  ","HERE HERE");

        try
        {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            if(state == null)
            {
                PhoneNumber = "UNKNOWN";
            }
            else if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                PhoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("INCOMING ","Incoming number : "+PhoneNumber);
            }
            if(intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL"))
            {

                PhoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
                Log.d("OUTGOING ","Outgoing number : "+PhoneNumber);

            }


            if(!PhoneNumber.contentEquals("UNKNOWN"))
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                {
                    context.startForegroundService(new Intent(context, CatchNumbers.class));
                }
                else
                {
                    context.startService(new Intent(context, CatchNumbers.class));
                }
            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e("RECEIVER EXCEPTION : ", "Exception is : ", e);
        }
    }
};

public WatchMan() { }

@Override
public void onCreate()
{
    super.onCreate();

    mBuilder = new NotificationCompat.Builder(this, null);

    IntentFilter filterstate = new IntentFilter();
    filterstate.addAction("android.intent.action.NEW_OUTGOING_CALL");
    filterstate.addAction("android.intent.action.PHONE_STATE");
    this.registerReceiver(mCallBroadcastReceiver, filterstate);

    Log.d("RECEIVER : ", "\nCreated....");

    mNotifyManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
    mBuilder = new NotificationCompat.Builder(this, null);
    mBuilder.setContentTitle("Insta Promo")
            .setContentText("Insta Promo Is Up..")
            .setTicker("Insta Promo Is Up..")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(Notification.PRIORITY_HIGH)
            .setDefaults(Notification.DEFAULT_ALL)
            .setVisibility(Notification.VISIBILITY_PUBLIC)
            .setOngoing(true)
            .setAutoCancel(false);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
    {

        notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);

        // Configure the notification channel.
        notificationChannel.setDescription("Channel description");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
        notificationChannel.enableVibration(true);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        mNotifyManager.createNotificationChannel(notificationChannel);
    }

    running = true;

    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
    startForeground(17, mBuilder.build());



}

@Override
public int onStartCommand(Intent intent, int flags, int startId)
{
    Log.d("RECEIVER : ", "\nOnStartCommand....");
    new Thread(new Runnable()
    {
        public void run()
        {
            while(running)
            {
                try
                {
                    Log.d("RECEIVER : ", "\nALIVE..");
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    Log.d("RECEIVER : ", "\nThread : InterruptedException in Receiver...");
                    Log.e("RECEIVER : ", "\nException is : ", e);
                }
                catch (Exception e)
                {
                    Log.d("RECEIVER : ", "\nThread : Exception Error in Receiver...");
                    Log.e("RECEIVER : ", "\nException is : ", e);
                }
            }

        }

    }).start();



    return START_STICKY;
}

@Override
public void onDestroy()
{
    this.unregisterReceiver(mCallBroadcastReceiver);
    running = true;
    Log.d("RECEIVER : ", "\nDestroyed....");
    Log.d("RECEIVER : ", "\nWill be created again....");
}

@Override
public IBinder onBind(Intent intent)
{
    // TODO: Return the communication channel to the service.
    throw new UnsupportedOperationException("Not yet implemented");
}

@Override
public void onTaskRemoved(Intent rootIntent)
{
    super.onTaskRemoved(rootIntent);
    Log.d("SERVICE : ", "\nTask Removed....");
}


}