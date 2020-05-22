long dateTime = calendar.getTimeInMillis();
 if (dateTime <= System.currentTimeMillis()) {
     time = dateTime + 24 * 3600 * 1000;
 } 
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        alarmManager.setWindow(AlarmManager.RTC_WAKEUP, dateTime ,
                AlarmManager.INTERVAL_DAY, pendingIntent);
    } else {
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dateTime , 
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }