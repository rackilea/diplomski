DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            .appendPattern("XX")
            .toFormatter();

    String[] stringsPassed = {
            "2018-11-01T16:26:15+0100",
            "2018-10-31T08:27:00.0000000Z"
    };

    for (String sample : stringsPassed) {
        OffsetDateTime odt = OffsetDateTime.parse(sample, formatter);
        System.out.println(odt);
    }