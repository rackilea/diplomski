ZoneId australianTime = ZoneId.of("Australia/Sydney");
    DateTimeFormatter receivedTimeFormat = DateTimeFormatter.ofPattern("HHmmss");
    DateTimeFormatter neededDateTimeFormatter 
            = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSS zzz", 
                                          Locale.forLanguageTag("en-AU"));
    LocalDate today = LocalDate.now(australianTime);
    LocalDate yesterday = today.minusDays(1);
    String receivedTimeString = "180000";
    LocalTime time = LocalTime.parse(receivedTimeString, receivedTimeFormat);
    String previousDayAtTime = yesterday.atTime(time)
            .atZone(australianTime)
            .format(neededDateTimeFormatter);
    System.out.println(previousDayAtTime);