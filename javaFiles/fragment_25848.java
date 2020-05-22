public class AlarmNotifReceiver extends BroadcastReceiver {

    PendingIntent pi;
    AlarmManager am;
    Intent i;

    @Override
    public void onReceive(Context context, Intent intent) {
        pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        i = new Intent(context, AlarmNotifReceiver.class);
        //things
    }

    public void SetAlarm(Context context) {

        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10 * 1000, pi);
    }

    public void CancelAlarm(Context context) {
        am.cancel(pi);
    }


}