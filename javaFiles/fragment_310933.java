DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("[uuuu][uu]-M-d")
            .optionalStart()
            .appendLiteral('T')
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .optionalEnd()
            .toFormatter();

    TemporalAccessor dt = formatter.parseBest("19-3-12", LocalDateTime::from, LocalDate::from);
    System.out.println(dt.getClass());
    System.out.println(dt);