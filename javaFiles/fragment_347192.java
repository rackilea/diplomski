AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    calendar.set(Calendar.HOUR_OF_DAY, 02);
    calendar.set(Calendar.MINUTE, 00);

// setRepeating() lets you specify a precise custom interval--in this case,
// 1 day
    alarmMgr.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis()/1000,
            AlarmManager.INTERVAL_DAY, alarmIntent);