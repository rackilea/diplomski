DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .toFormatter();
    ZoneId zone = ZoneId.of("America/New_York");

    String dateTime = "2018-04-23 19:50:53.236";
    ZonedDateTime usEasternTime = LocalDateTime.parse(dateTime, inputFormatter)
            .atOffset(ZoneOffset.UTC)
            .atZoneSameInstant(zone);
    String formattedDateTime = usEasternTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    System.out.println(formattedDateTime);