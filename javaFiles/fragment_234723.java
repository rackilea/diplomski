Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, 16);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);

AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

Intent intent = new Intent(ACTION_SCR_OFF);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent,
    PendingIntent.FLAG_UPDATE_CURRENT);
am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
    AlarmManager.INTERVAL_DAY, pendingIntent);