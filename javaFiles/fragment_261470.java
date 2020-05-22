Calendar current = Calendar.getInstance();
Calendar calSet = Calendar.getInstance();

   calSet.set(Calendar.HOUR_OF_DAY, 7);
   calSet.set(Calendar.MINUTE, 0);
   calSet.set(Calendar.SECOND, 0);

   if(calSet.compareTo(current) <= 0){
    //If time passed add for tomo
    calSet.add(Calendar.DATE, 1);
   }

   setAlarm(calSet);
  }};

 private void setAlarm(Calendar cal){


  Intent intent = new Intent(getBaseContext(), CustomReceiver.class);
  PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 1, intent, 0);
  AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
  alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY,
                pendingIntent);
 }