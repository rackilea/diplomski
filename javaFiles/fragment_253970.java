String time = "2 Jun 2019 03:51:17 PM ACST";
String pattern = "d MMM yyyy hh:mm:ss a z";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

TemporalAccessor parsedTime = formatter.parse(time);

ZoneId zone = parsedTime.query(ZoneId::from);

LocalDateTime localDateTime = parsedTime.query(LocalDateTime::from);

Instant instant = parsedTime.query(Instant::from);

System.out.println(zone);
System.out.println(localDateTime);
System.out.println(instant);