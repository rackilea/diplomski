SimpleDateFormat gmtFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm", Locale.US);
gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

SimpleDateFormat finlandFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm zzz", Locale.US);
finlandFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));

SimpleDateFormat plus3Format = new SimpleDateFormat("yyyy/MM/dd kk:mm zzz", Locale.US);
plus3Format.setTimeZone(TimeZone.getTimeZone("GMT+3"));

Date date = gmtFormat.parse("1970/01/01 12:00");
System.out.println("Time Is: " + gmtFormat.format(date));
System.out.println("Time Is: " + finlandFormat.format(date));
System.out.println("Time Is: " + plus3Format.format(date));

date = gmtFormat.parse("2016/04/22 12:00");
System.out.println("Time Is: " + gmtFormat.format(date));
System.out.println("Time Is: " + finlandFormat.format(date));
System.out.println("Time Is: " + plus3Format.format(date));