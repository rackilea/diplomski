/Create alarm manager

 AlarmManager mAlarmManger = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

 //Create pending intent & register it to your alarm notifier class
 Intent intent = new Intent(this, AlarmReceiver_maandag_1e.class);
 intent.putExtra("uur", "1e"); // if you want
 PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

 //set timer you want alarm to work (here I have set it to 9.00)
 Calendar calendar = Calendar.getInstance();
 calendar.set(Calendar.HOUR_OF_DAY, 9);
 calendar.set(Calendar.MINUTE, 0);
 calendar.set(Calendar.SECOND, 0);

 //set that timer as a RTC Wakeup to alarm manager object
 mAlarmManger .set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);