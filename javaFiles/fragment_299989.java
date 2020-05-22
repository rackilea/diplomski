LocalDate date = LocalDate.of(2014, 10, 2);
Locale jpLocale = new Locale("ja", "JP", "JP");
Chronology chrono = Chronology.ofLocale(jpLocale);
DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
        .withLocale(jpLocale)
        .withChronology(chrono);
String jpDateStr = date.format(f);
LocalDate result = LocalDate.parse(jpDateStr, f);