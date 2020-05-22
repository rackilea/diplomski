Locale locale = new Locale("ru");

    ChronoFormatter<LocalDate> formatter =
        ChronoFormatter.ofPattern(
            "LLLL",
            PatternType.CLDR,
            locale,
            PlainDate.axis(TemporalType.LOCAL_DATE)
        );
    System.out.println(formatter.format(LocalDate.now()));

    // ru => Февраль
    // en => February