public static LocalDate parseDateString(String date) {
    DateTimeFormatter parser = new DateTimeFormatterBuilder()
            .appendPattern("dd-MM-")
            .appendValueReduced(ChronoField.YEAR, 2, 4, 1900)
            .toFormatter(Locale.forLanguageTag("nl-NL"));
    return java.time.LocalDate.parse(date, parser);
}