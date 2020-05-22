SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

Date day1 = simpleDateFormat.parse("12/10/2017 23:00:00");
Date day2 = simpleDateFormat.parse("13/10/2017 07:30:00");

DateTime dt1 = new DateTime(day1);
DateTime dt2 = new DateTime(day2);

System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes.");
// Should print "8 hours, 30 minutes.'