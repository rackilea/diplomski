Calendar now = Calendar.getInstance();
Calendar calendar = Calendar.getInstance();
calendar.setTimeInMillis(System.currentTimeMillis());
calendar.set(Calendar.HOUR_OF_DAY, yourHour);
calendar.set(Calendar.MINUTE, yourMin);
calendar.set(Calendar.SECOND, youSec);

if (calendar.before(now)) { //if time passed
    calendar.add(Calendar.DATE,1);
}
Intent intent = new Intent(Context.this, DestinationActivity.class);
PendingIntent pendingIntent = PendingIntent.getActivity
               (Settings.this,123456, intent, PendingIntent.FLAG_UPDATE_CURRENT);
AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                        AlarmManager.INTERVAL_DAY,pendingIntent);