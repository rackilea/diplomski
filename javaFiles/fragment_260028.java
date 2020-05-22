public void SaveAlarm(View V) {
    Intent myIntent = new Intent(SetAlarm.this, NotifyReceiver.class);
    AlarmManager mAlarmManager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
    mPendingIntent = PendingIntent.getBroadcast(SetAlarm.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
   ...
}