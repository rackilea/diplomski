LocalDate date = LocalDate.parse("2018-04-10");

        LocalDateTime localDateTime = date.atStartOfDay();

        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));

        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));