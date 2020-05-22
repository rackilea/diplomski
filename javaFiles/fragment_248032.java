// this gets a calendar for your default timezone
Calendar cal = GregorianCalendar.getInstance();
// remove the timepart of your timezone
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);
// shows your local date at 00:00
System.out.println(new Date(cal.getTimeInMillis()));