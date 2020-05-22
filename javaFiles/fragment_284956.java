Intent myIntent = new Intent(ThisApp.this , myService.class);     
       AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
       pendingIntent = PendingIntent.getService(ThisApp.this, 0, myIntent, 0);

       Calendar calendar = Calendar.getInstance();
           calendar.set(Calendar.HOUR_OF_DAY, 12);
       calendar.set(Calendar.MINUTE, 00);
       calendar.set(Calendar.SECOND, 00);

      alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 24*60*60*1000 , pendingIntent);  //set repeating every 24 hours