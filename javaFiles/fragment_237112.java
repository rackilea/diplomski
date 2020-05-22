public class Autostart extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1)
    {
        PendingIntent pendingIntent = PendingIntent.getBroadcast(arg0, 0, new Intent("com.example.application.myNotification"), 0);
        AlarmManager alarmMgr = (AlarmManager) (arg0.getSystemService(Context.ALARM_SERVICE));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 6);

        long mills = calendar.getTimeInMillis();
        if (mills <= System.currentTimeMillis()) {
            Calendar c1 = calendar;
            c1.add(Calendar.DAY_OF_MONTH, 1);
            mills = c1.getTimeInMillis();
        } else {
            mills = calendar.getTimeInMillis();
        }

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, mills, 1000 * 60 * 60 * 24, pendingIntent);

        Log.i("Autostart", "started");
    }

}