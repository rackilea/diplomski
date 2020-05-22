public class FirstReceiver extends BroadcastReceiver
{
//do what ever you want + code bellow to setup second alarm manager
 Intent intent = new Intent(this, SecAlarm.class);
 PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
 AlarmManager am=  (AlarmManager)getSystemService(Context.ALARM_SERVICE);
am.setRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime(),
                15*60*60,pendingIntent);
}