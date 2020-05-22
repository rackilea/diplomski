public static String ALARM_TO_SET = "ALRMTOSEND";
yourButton.setOnClickListener(new OnClickListener(){
public void onClick(View view){
     int time = 10 * 1000;

    intentAlarm = new Intent(ALARM_TO_SET);

    alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, intentAlarm, 0)
    alarm.setRepeating(AlarmManager.RTC_WAKEUP, time, time, pIntent);


  }
});