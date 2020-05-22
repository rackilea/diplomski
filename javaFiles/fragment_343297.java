String valueWithDate = "00092017";
String pattern = "ddMMyyyy";
// create formatter with the pattern and strict mode
DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
// parse the input
TemporalAccessor parsed = fmt.parse(valueWithDate);

// get day from the parsed object
int day = (int) parsed.getLong(ChronoField.DAY_OF_MONTH);
if (day == 0) {
    day = 1;
}
// get month from the parsed object
int month = (int) parsed.getLong(ChronoField.MONTH_OF_YEAR);
if (month == 0) {
    month = 1;
}
// get year from the parsed object
int year = (int) parsed.getLong(ChronoField.YEAR_OF_ERA);

// the final value will have the same pattern? if so, just use the same formatter
String value = fmt.format(LocalDate.of(year, month, day));
System.out.println(value); // 01092017