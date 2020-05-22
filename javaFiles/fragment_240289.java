Intent intent = new Intent(this, AlarmReciever.class);
    AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MINUTE, 6);
    cal.set(Calendar.HOUR, 9);
    cal.set(Calendar.AM_PM, Calendar.PM); 
    alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
    AlarmManager.INTERVAL_DAY, pIntent);