String input = "2011-08-11T01:23:45.678Z";
TimeZone utc = TimeZone.getTimeZone("UTC");
SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
f.setTimeZone(utc);
GregorianCalendar cal = new GregorianCalendar(utc);
cal.setTime(f.parse(input));
System.out.println(cal.getTime());