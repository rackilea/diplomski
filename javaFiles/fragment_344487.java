ChronoFormatter<CalendarWeek> f =
    ChronoFormatter.ofPattern(
        "YYYYww",
        PatternType.CLDR,
        Locale.ROOT,
        CalendarWeek.chronology()
    );
CalendarWeek cw = f.parse("201803");
java.time.LocalDate d = cw.at(Weekday.MONDAY).toTemporalAccessor();
System.out.println(d); // 2018-01-15