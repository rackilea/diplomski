// The AlarmReceiver will be called when the user need to be reminded. 
// and using putExtra you can save the concert data, e.g. the concert name.
Intent intent = new Intent(mContext, AlarmReceiver.class);
String[] texts = new String[4];
texts[0] = CONCERT_NAME;
intent.putExtra("alarm_message", texts);

PendingIntent sender = PendingIntent.getBroadcast(mContext, CONCERT_ID, intent, 0);

// Create an alarm manager
AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
am.set(AlarmManager.RTC_WAKEUP, CONCERT_TIME_IN_MILLIS, sender);