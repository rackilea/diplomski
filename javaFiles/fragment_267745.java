Date dt = new Date(1293840000000L);

TimeZone.setDefault(TimeZone.getTimeZone("America/Chicago"));
DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
String dateStr = sdf.format(dt);
System.out.println(dateStr); //prints 2010-12-31T18:00:00 -0600

TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
dateStr = sdf.format(dt);
System.out.println(dateStr); //prints 2011-01-01T00:00:00 +0000