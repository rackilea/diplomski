AlarmManager manager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

Intent alarmIntent = new Intent(this.getApplicationContext(), AlarmReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(System.currentTimeMillis());
calendar.add(Calendar.SECOND, 30);

manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 60 * 3600, pendingIntent);