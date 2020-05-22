ZoneId zone = ZoneId.systemDefault();
    long endOfDay = LocalDate.now(zone)
            .plusDays(1)
            .atStartOfDay(zone)
            .toInstant()
            .minusMillis(1)
            .toEpochMilli();
    System.out.println(endOfDay);