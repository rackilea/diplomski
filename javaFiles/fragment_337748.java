long dateTime = calendar.getTimeInMillis();
 if (dateTime <= System.currentTimeMillis()) {
     time = dateTime + 24 * 3600 * 1000;
 } 
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, dateTime, pendingIntent); // not suggested
        // 15 mins of window to call the alarm and have battery optimization
        long windowMillis = 15 * 60 * 1000L;
        alarmManager.setWindow(AlarmManager.RTC_WAKEUP, dateTime ,
                windowMillis, pendingIntent);
    } else {
        alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime, pendingIntent);
    }