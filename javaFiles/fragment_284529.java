String mydate = "20130812214600025";
String adjustedInput = new StringBuilder(mydate).insert(14, '.').toString();
ZonedDateTime date =
    ZonedDateTime.parse(
        adjustedInput,
        DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS").withZone(ZoneOffset.systemDefault()));
System.out.println(date); // 2013-08-12T21:46:00.025+02:00[Europe/Berlin]
System.out.println(date.toInstant().toEpochMilli()); // 1376336760025