String readPattern = "yyyy-MM-dd HH:mm:ss.S";
DateTimeFormatter readDateTimeFormatter = DateTimeFormatter.ofPattern(readPattern).withZone(ZoneOffset.UTC);
LocalDateTime utcLocalDateTime = LocalDateTime.parse("2018-03-13 03:00:00.0", readDateTimeFormatter);
ZonedDateTime localZonedDateTime = utcLocalDateTime.atOffset(ZoneOffset.UTC).atZoneSameInstant(ZoneId.systemDefault());
String writePattern = "yyyy-MM-dd HH:mm:ssXXX";
DateTimeFormatter writeDateTimeFormatter = DateTimeFormatter.ofPattern(writePattern);
System.out.println(writeDateTimeFormatter.format(localZonedDateTime));