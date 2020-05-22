ZoneId zone = ZoneId.of("Asia/Chungking");
    ZonedDateTime at2000 = LocalDate.now(zone)
            .atTime(LocalTime.of(20, 0))
            .atZone(zone);
    if (at2000.isBefore(ZonedDateTime.now(zone))) {
        // Time has passed for today; use tomorrow
        at2000 = at2000.plusDays(1);
    }
    Date dateForScheduler = Date.from(at2000.toInstant());