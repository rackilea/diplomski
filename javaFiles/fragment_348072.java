Calendar firingCal = Calendar.getInstance();
Calendar currentCal = Calendar.getInstance();

firingCal.set(Calendar.HOUR_OF_DAY, 11); //24-hour format 
firingCal.set(Calendar.MINUTE, 00);
firingCal.set(Calendar.SECOND, 00);

long intendedTime = firingCal.getTimeInMillis();
long currentTime = currentCal.getTimeInMillis();

if(intendedTime >= currentTime) 
{
    //this will set the alarm for current day if time is below 11 am
    alarmManager.setRepeating(AlarmManager.RTC, intendedTime , AlarmManager.INTERVAL_DAY, pendingIntent);
}
else {
    //this will set the alarm for the next day
    firingCal.add(Calendar.DAY_OF_MONTH, 1);
    intendedTime = firingCal.getTimeInMillis();
    alarmManager.setRepeating(AlarmManager.RTC, intendedTime , 
    AlarmManager.INTERVAL_DAY, pendingIntent);
}