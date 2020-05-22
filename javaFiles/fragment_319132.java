LocalDateTime oldDateTime = LocalDateTime.parse("2015-10-10T10:00:00");
ZoneId oldZone = ZoneId.of("America/Chicago");

ZoneId newZone = ZoneId.of("America/New_York");
LocalDateTime newDateTime = oldDateTime.atZone(oldZone)
                                       .withZoneSameInstant(newZone)
                                       .toLocalDateTime();
System.out.println(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));