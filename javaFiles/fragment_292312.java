AlarmManager alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(getApplicationContext(),
            xyz.class);

    PendingIntent alarmIntent = PendingIntent
            .getService(getApplicationContext(), 0, intent,
                    PendingIntent.FLAG_ONE_SHOT);

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 14);
    calendar.set(Calendar.MINUTE, 00);
    calendar.set(Calendar.SECOND, 00);

    alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,
            calendar.getTimeInMillis(), 1000 * 60 * 60 * 24, alarmIntent);