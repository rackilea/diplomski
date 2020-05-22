// timezone independent date (usually interpreted by the timezone of 
// the default locale of the user machine)
Date now = new Date();

// now lets get explicit with how we wish to interpret the date
Calendar london =  Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
Calendar paris = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));

// now set the same date on two different calendar instance
london.setTime(now);
paris.setTime(now);

// the time is the same
assert london.getTimeInMillis() == paris.getTimeInMillis();

// London is interpreted one hour earlier than Paris (as of post date of 9th May 2012)
String londonTime = london.get(Calendar.HOUR) + ":" + london.get(Calendar.MINUTE);
String londonTZ = london.getTimeZone().getDisplayName(london.getTimeZone().inDaylightTime(london.getTime()), TimeZone.SHORT);
System.out.println(londonTime + " " + londonTZ);

// Paris is interpreted one hour later than Paris (as of post date of 9th May 2012)
String parisTime = paris.get(Calendar.HOUR) + ":" + paris.get(Calendar.MINUTE);
String parisTZ = paris.getTimeZone().getDisplayName(paris.getTimeZone().inDaylightTime(paris.getTime()), TimeZone.SHORT);
System.out.println(parisTime + " " + parisTZ);