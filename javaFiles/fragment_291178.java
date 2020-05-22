LocalDate d = LocalDate.now();
LocalTime time = LocalTime.now();
ZoneId zone = ZoneId.systemDefault();
ZonedDateTime zonedDateTime = ZonedDateTime.of(d, time, zone);
String zoneDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(zonedDateTime);
ZonedDateTime utcZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(ZoneOffset.UTC.getId()));
String utcZoneDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(utcZonedDateTime);

System.out.println(zoneDate);
System.out.println(utcZoneDate);