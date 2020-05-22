public class BootReceiver extends BroadcastReceiver {
    @Override
       public void onReceive(Context context, Intent intent) {

          AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
          PendingIntent pendingIntent =
                   PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);

          alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 2000,  60000, pendingIntent);
       }
    }