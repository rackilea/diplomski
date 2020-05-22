ZoneId zone = ZoneId.of("America/Chicago");

    ZonedDateTime zdt = ZonedDateTime.now(zone).plusDays(2).plusMinutes(30);

    LocalTime rangeStart = LocalTime.parse("10:11:13");
    LocalTime rangeEnd = LocalTime.parse("18:49:00");

    LocalTime time = zdt.toLocalTime();
    if (!time.isBefore(rangeStart) && time.isBefore(rangeEnd)) {
        System.out.println("Yes");
    } else {
        System.out.println("No");
    }