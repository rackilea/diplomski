ZoneId zone = ZoneId.of("Europe/London");
    ZonedDateTime dateTime = ZonedDateTime.of(2019, 10, 27, 0, 30, 0, 0, zone);
    for (int i = 0; i < 4; i++) {
        System.out.println(dateTime);
        dateTime = dateTime.plusHours(1);
    }