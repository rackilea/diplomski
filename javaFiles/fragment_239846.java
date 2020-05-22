public static TemporalAccessor parse(String pattern, String input) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern, Locale.ROOT);
    final TemporalAccessor parsed = fmt.parse(input);
    // check year and year of era
    boolean hasYear = parsed.isSupported(ChronoField.YEAR);
    boolean hasYearEra = parsed.isSupported(ChronoField.YEAR_OF_ERA);
    if (!hasYear && !hasYearEra) {
        // parsed value doesn't have any year field
        // return another TemporalAccessor with default value for year
        // using year 1970 - change it to Year.now().getValue() for current year
        return withYear(parsed, 1970); // see this method's code below
    }
    return parsed;
}