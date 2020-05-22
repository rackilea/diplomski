private void scheduleAlarm(AlarmManager alarmManager, long targetTime, PendingIntent pendingIntent, Intent intent) {
    if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // Lollipop is version 21
        // Code for versions after Lollipop
        alarmLaterLollipop();
    }
    else {
        // Code for older versions
        alarmBeforeLollipop();
    }
}

@TargetApi(Build.VERSION_CODES.M)
private void alarmLaterLollipop(){
    logAlarm(targetTime, pendingIntent, intent, "Lollipop");
    alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(targetTime, pendingIntent),pendingIntent);
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
private void alarmBeforeLollipop(){
    logAlarm(targetTime, pendingIntent, intent, "Kitkat");
    alarmManager.setExact(AlarmManager.RTC_WAKEUP, targetTime, pendingIntent);
}