public void startAlarm(View view) {
    manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
    int interval = 10000;

    manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
    Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
}