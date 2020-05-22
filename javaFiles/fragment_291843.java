final String dateStart = "01/14/2012 09:29:58";
  final String dateStop = "01/15/2012 10:31:48";
  final DateTimeFormatter format = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
  final DateTime dt1 = format.parseDateTime(dateStart);
  final DateTime dt2 = format.parseDateTime(dateStop);

  System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
  System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
  System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
  System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");