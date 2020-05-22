DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            // time is optional
            .optionalStart()
            .parseCaseInsensitive()
            .appendPattern("[ ]['T']")
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .optionalEnd()
            // offset is optional
            .appendPattern("[xx]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.OFFSET_SECONDS, 0)
            .toFormatter();
    for (String queryParam : new String[] {
            "2017-05-05 00:00:00.000+0000",
            "2017-05-05 00:00:00.000",
            "2017-05-05T00:00:00",
            "2017-05-05+0000",
            "2017-05-05",
            "2017-05-05T11:20:30.643+0000",
            "2017-05-05 16:25:09.897+0000",
            "2017-05-05 22:13:55.996",
            "2017-05-05t02:24:01"
    }) {
        Instant inst = OffsetDateTime.parse(queryParam, formatter).toInstant();
        System.out.println(inst);
    }