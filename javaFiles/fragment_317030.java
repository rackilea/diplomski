OffsetDateTime java8OffsetDateTime = OffsetDateTime.parse(candidate, offsetDateTimeFormatter );

DateTimeFormatter customOffsetDateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy[-MM][-dd['T'HH[:mm[:ss]]]][.SSSXXX]")
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
            .parseDefaulting(ChronoField.OFFSET_SECONDS, ZoneOffset.of("-08:00").getTotalSeconds())
            .toFormatter();