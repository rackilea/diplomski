Stream<Row> readData = Stream.of(
        "2019-01-23T10:12:31    100",
        "2019-01-24T00:12:30    50",
        "2019-01-24T09:00:00    23",
        "2019-01-25T03:00:00    23",
        "2019-01-27T05:10:00    65")

        .map(s -> s.split("\\s+"))
        .map(a -> new Row(LocalDateTime.parse(a[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME), Integer.valueOf(a[1])));