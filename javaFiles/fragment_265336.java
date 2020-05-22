public static void registerAlarm(Context context) {
    Intent i = new Intent(context, YOURBROADCASTRECIEVER.class);

    PendingIntent sender = PendingIntent.getBroadcast(context,REQUEST_CODE, i, 0);

    // We want the alarm to go off 3 seconds from now.
    long firstTime = SystemClock.elapsedRealtime();
    firstTime += 3 * 1000;//start 3 seconds after first register.

    // Schedule the alarm!
    AlarmManager am = (AlarmManager) context
            .getSystemService(ALARM_SERVICE);
    am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime,
            600000, sender);//10min interval

}