String time1 = "26-NOV-01 12.00.00.000000000 PM -07:00";
String time2 = "26-NOV-01 12.00.00.000000000 PM -08:00";
DateTimeFormatter parser = DateTimeFormat.forPattern("dd-MMM-yy hh.mm.ss.SSSSSSSSS aa Z").withZoneUTC(); // joda time date time formatter instance with a common UTC timezone

System.out.println(parser.parseDateTime(time1)); // parse to date time - gives: 2001-11-26T19:00:00.000Z
System.out.println(parser.parseDateTime(time2)); // parse to date time - gives: 2001-11-26T20:00:00.000Z

System.out.println(parser.parseDateTime(time2).compareTo(parser.parseDateTime(time1))); // Comparing both the times here - gives: 1