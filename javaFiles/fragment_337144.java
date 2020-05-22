//Joda
String jtDate = "2010-01-01T12:00:00+01:00";
DateTimeFormatter yoda = ISODateTimeFormat.dateTimeNoMillis();
System.out.println(parser2.parseDateTime(jtDate));

//using Java 8 (As you specified - To convert "+0100" to "+01:00"    is easy enough.)
String strDate = "2017-01-05T16:32:29+01:00";
DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
TemporalAccessor convertMe = timeFormatter.parse(strDate);
Date date = Date.from(Instant.from(convertMe));
System.out.println(date);