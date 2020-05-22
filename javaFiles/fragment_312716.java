Calendar calendar = GregorianCalendar.getInstance();
String iso8601Date = "2017-04-04T09:00:00-08:00";
// get the offset (-08:00)
String offset = iso8601Date.substring(19);
TimeZone tz = TimeZone.getTimeZone("GMT" + offset);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
// set the offset in the formatter
sdf.setTimeZone(tz);
// parse just date and time (without the offset)
Date date = sdf.parse(iso8601Date.substring(0, 19));
// set the offset in the calendar
calendar.setTimeZone(tz);
calendar.setTime(date);