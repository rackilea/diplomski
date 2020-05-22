if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(d.getTime(),pendingIntent),pendingIntent);
else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
    alarmManager.setExact(AlarmManager.RTC, d.getTime(), pendingIntent);
else
    alarmManager.set(AlarmManager.RTC, d.getTime(), pendingIntent);