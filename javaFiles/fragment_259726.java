final TimeZone tz = TimeZone.getTimeZone("GMT+0200");
final Calendar cal = Calendar.getInstance(tz);
cal.setTimeInMillis(1310481956000L);
final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
f.setTimeZone(tz);
System.out.println(f.format(cal.getTime()));