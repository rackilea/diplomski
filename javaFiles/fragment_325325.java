// We want the alarm to go off 30 seconds from now.
long firstTime = SystemClock.elapsedRealtime();
firstTime += remainingMilisecondsToTopHour;
long a=c.getTimeInMillis();

// Schedule the alarm!
AlarmManager am = (AlarmManager)ctx.getSystemService(Context.ALARM_SERVICE);
am.setRepeating(AlarmManager.ELAPSED_REALTIME,
c.getTimeInMillis(), 1*60*60*1000, sender);