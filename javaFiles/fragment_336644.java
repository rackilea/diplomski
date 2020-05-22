public class AlarmReceiver extends BroadcastReceiver {

 @Override
 public void onReceive(Context context, Intent intent) {

  Toast.makeText(context, 
   "AlarmReceiver.onReceive()", 
   Toast.LENGTH_LONG).show();
 }

}