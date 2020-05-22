// get today's time
Calendar today = Calendar.getInstance();
// print today date with current time,
System.out.println("Date before time is set: " + today.getTime());

// set today's hour to above time
today.set(Calendar.HOUR, cal.get(Calendar.HOUR));
// set today's minute to above time
today.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
// set today's seconds to above time
today.set(Calendar.SECOND, cal.get(Calendar.SECOND));
// print your new time
System.out.println("Date after time is set: " + today.getTime());