ZoneId userTimeZone = ZoneId.systemDefault();

    String date = "2019-12-25";

    LocalDateTime localDateTime = LocalDate.parse(date).atStartOfDay();
    System.out.println("localDateTime: " + localDateTime);

    OffsetDateTime utcDateTime = localDateTime.atZone(userTimeZone)
            .toOffsetDateTime()
            .withOffsetSameInstant(ZoneOffset.UTC);
    System.out.println("utcDateTime: " + utcDateTime);