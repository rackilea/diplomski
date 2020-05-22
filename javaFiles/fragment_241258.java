DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .appendPattern("HH:mm:ss.SSSSSSSXXX")
            .toFormatter();
    String desiredString = OffsetDateTime.now(ZoneId.systemDefault())
                                .format(formatter);