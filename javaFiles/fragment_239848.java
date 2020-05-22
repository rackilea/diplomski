public static LocalDate parseLocalDate(String pattern, String input) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern, Locale.ROOT);

    // try to create a LocalDate first
    // if not possible, try to create a MonthDay
    TemporalAccessor parsed = fmt.parseBest(input, LocalDate::from, MonthDay::from);

    LocalDate dt = null;

    // check which type was created by the parser
    if (parsed instanceof LocalDate) {
        dt = (LocalDate) parsed;
    } else if (parsed instanceof MonthDay) {
        // using year 1970 - change it to Year.now().getValue() for current year
        dt = ((MonthDay) parsed).atYear(1970);
    } // else etc... - do as many checkings you need to handle all possible cases

    return dt;
}