// Java-6 (SimpleDateFormat)
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
String text = sdf.format(new Date());
text = text.substring(0, text.length() - 2) + ":" + text.substring(text.length() - 2);
System.out.println(text);

// Joda-Time
DateTime now = DateTime.now();
System.out.println(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").print(now));

// Time4J
Moment now = SystemClock.currentMoment();
System.out.println(Iso8601Format.EXTENDED_DATE_TIME_OFFSET.withStdTimezone().format(now));