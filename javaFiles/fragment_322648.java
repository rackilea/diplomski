Intent intent = new Intent(this, AlarmReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadtcast(this, 0,
        intent, PendingIntent.FLAG_CANCEL_CURRENT);

AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
long triggerTime = System.currentTimeMillis() + 10 * DateUtils.SECOND_IN_MILLIS;
alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);

finish();