DateFormat formatterIST = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
formatterIST.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); // better than using IST
Date date = formatterIST.parse("15-05-2014 00:00:00");
System.out.println(formatterIST.format(date)); // output: 15-05-2014 00:00:00

DateFormat formatterUTC = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC timezone
System.out.println(formatterUTC.format(date)); // output: 14-05-2014 18:30:00

// output in system timezone using pattern "EEE MMM dd HH:mm:ss zzz yyyy"
System.out.println(date.toString()); // output in my timezone: Wed May 14 20:30:00 CEST 2014