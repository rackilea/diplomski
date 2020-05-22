ChronoFormatter<PlainDate> f =
    ChronoFormatter
        .ofDatePattern("YYYYww", PatternType.CLDR, Locale.ROOT)
        .withDefault(PlainDate.DAY_OF_WEEK, Weekday.MONDAY);
PlainDate cw = f.parse("201803");
java.time.LocalDate d = cw.toTemporalAccessor();