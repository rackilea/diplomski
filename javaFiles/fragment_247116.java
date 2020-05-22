First of all you need to use the Service for this functionality to work.

In the Activity you can start and stop the service by using the below codes.

//to start a service
Intent service = new Intent(context, MyBrodcastRecieverService.class);
context.startService(service);

//to Stop service
Intent service = new Intent(context, MyBrodcastRecieveService.class);
context.stopService(service);



Then you can use the below service 


public class MyBrodcastRecieveService extends Service
{
 private static BroadcastReceiver br_ScreenOffReceiver;

 @Override
 public IBinder onBind(Intent arg0)
 {
  return null;
 }

 @Override
 public void onCreate()
 {
  registerScreenOffReceiver();
 }

 @Override
 public void onDestroy()
 {
  unregisterReceiver(br__ScreenOffReceiver);
  m_ScreenOffReceiver = null;
 }

 private void registerScreenOffReceiver()
 {
  br_ScreenOffReceiver = new BroadcastReceiver()
  {
   @Override
   public void onReceive(Context context, Intent intent)
   {
     Log.d(TAG, "ACTION_SCREEN_OFF");
     // do something, e.g. send Intent to main app
   }
  };
  IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
  registerReceiver(br_ScreenOffReceiver, filter);
 }
}