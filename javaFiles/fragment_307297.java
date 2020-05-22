public class AlarmReceiver extends BroadcastReceiver {
    private String TAG = "AlarmReceiver";
   // onReceive must be very quick and not block, so it just fires up a Service
   @Override
   public void onReceive(Context context, Intent intent) {     
      Intent i = new Intent(context, MyLovelyService.class);      
      PendingIntent.getService(context, 0,i, 0).send();    
   }
}