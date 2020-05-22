AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
Intent myIntent;
PendingIntent pendingIntent;
long reminderDateTimeInMilliseconds = 000;

myIntent = new Intent(this,MedicationScheduleBroadCastReceiver.class);

pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT);

//TODO : Reminder the user to take medication on the 13th July 2018 at 15:30
// Note: For the month of July the int value will actuall be 6 instead of 7
Calendar calendarToSchedule = Calendar.getInstance();
calendarToSchedule.setTimeInMillis(System.currentTimeMillis());
calendarToSchedule.clear();

//.Set(Year, Month, Day, Hour, Minutes, Seconds);
calendarToSchedule.set(2018, 06, 13, 15, 30, 0);


reminderDateTimeInMilliseconds = calendarToSchedule.getTimeInMillis();

if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, reminderDateTimeInMilliseconds, pendingIntent);
}
else{

    manager.set(AlarmManager.RTC_WAKEUP, reminderDateTimeInMilliseconds, pendingIntent);
}