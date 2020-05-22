AlarmManager am = (AlarmManager)     DialerService.this.getSystemService(Context.ALARM_SERVICE);
    Print("inside scheduleAlarm  "+interval);
    logger.writeLog("inside schedule alarm and interval is "+interval);
    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+oneHour*interval, getPendingIntent(yourContext,AlarmID));



 private PendingIntent getPendingIntent(Context context, int id) {
    Intent intent =  new Intent(context, AlarmReciever.class)
            .putExtra("alarmId", id);
    return PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
}