//call notification activation Intent
Intent intent = new Intent(getBaseContext(), AlarmReciever.class);
int RQS_1 = (int) System.currentTimeMillis();
PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, PendingIntent.FLAG_ONE_SHOT);
AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);