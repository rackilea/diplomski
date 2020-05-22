public class TimerService extends Service {

   @Override
   public IBinder onBind(Intent intent) {
       return null;
   }

   @Override
   public void onCreate() {
       super.onCreate();
       Log.i("SERVICE", "CREATED");
   }

   @Override
   public void onDestroy() {
       super.onDestroy();   
       Log.i("SERVICE", "DESTROYED");
       //Save your timer instance on destroy service
   }

   @Override
   public void onLowMemory() {
       super.onLowMemory();
       Log.i("SERVICE", "LOW MEMORY");
   }


   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
     //Retrieve the timer instance here and use it... 

       //Restart service if Android destroys it!
       return Service.START_NOT_STICKY; 
   } 
}