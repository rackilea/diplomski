ZoneId australia = ZoneId.of("Australia/Sydney");
String str = "2015-01-05 17:00";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime localtDateAndTime = LocalDateTime.parse(str, formatter);
ZonedDateTime dateAndTimeInSydney = ZonedDateTime.of(localtDateAndTime, australia );

System.out.println("Current date and time in a particular timezone : " + dateAndTimeInSydney);

ZonedDateTime utcDate = dateAndTimeInSydney.withZoneSameInstant(ZoneOffset.UTC);

System.out.println("Current date and time in UTC : " + utcDate);