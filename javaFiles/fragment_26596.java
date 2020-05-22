DateTimeFormatter formatter = new DateTimeFormatterBuilder()
    .parseCaseInsensitive()
    .append(DateTimeFormatter.ofPattern("EEEE MMMM d"))
    // use English Locale to correctly parse month and day of week
    .toFormatter(Locale.ENGLISH);
// parse input
TemporalAccessor parsed = formatter.parse("TUESDAY JULY 25");
// get month and day
MonthDay md = MonthDay.from(parsed);
// get day of week
DayOfWeek dow = DayOfWeek.from(parsed);
LocalDate date;
// start with some arbitrary year, stop at some arbitrary value
for(int year = 2017; year > 1970; year--) {
    // get day and month at the year
    date = md.atYear(year);
    // check if the day of week is the same
    if (date.getDayOfWeek() == dow) {
        // found: 'date' is the correct LocalDate
        break;
    }
}