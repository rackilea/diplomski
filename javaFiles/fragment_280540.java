public int setAlarm() {
Calendar cal = Calendar.getInstance();
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
Intent myIntent = new Intent(this, AlarmReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis() , AlarmManager.INTERVAL_HOUR, pendingIntent);
return 0;
}