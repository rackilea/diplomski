final String time = "26/8/2013 15:59";
TimeZone timeZone = TimeZone.getTimeZone("UTC");
final String REQUEST_DATE_FORMAT = "dd/MM/yyyy h:m";

DateFormat format = new SimpleDateFormat(REQUEST_DATE_FORMAT);
Date localDate = format.parse(time);

// localDate.toString()
// PRINT. Mon Aug 26 15:59:00 EEST 2013

Calendar cal = Calendar.getInstance(timeZone);
cal.setTime(localDate);

format.setTimeZone(timeZone);
final String utcTime = format.format(cal.getTime());
// PRINT. 26/08/2013 12:59