int hour = calendar.get(Calendar.HOUR_OF_DAY);

    Intent intent1 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, hour, AlarmManager.INTERVAL_HOUR, pendingIntent);