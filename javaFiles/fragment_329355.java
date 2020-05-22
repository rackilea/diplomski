SimpleDateFormat f = new SimpleDateFormat("yyyyMMddhhmmss z");
f.setTimeZone(TimeZone.getTimeZone("UTC"));
Date time = f.parse("20000603163334 GST");
System.out.println(time);
System.out.println("(yyyyMMddhhmmss z):  " + f.format(time));

SimpleDateFormat utc = new SimpleDateFormat("yyyyMMddhhmmss z");
utc.setTimeZone(TimeZone.getTimeZone("UTC"));

System.out.println("(yyyyMMddhhmmss z):  " + utc.format(time));