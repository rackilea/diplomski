// April 2017
YearMonth ym = YearMonth.of(2017, 4);
// get the last day of month
int lastDay = ym.lengthOfMonth();
// loop through the days
for(int day = 1; day <= lastDay; day++) {
    // create the day
    LocalDate dt = ym.atDay(day);
    // set to midnight at JVM default timezone
    ZonedDateTime z = dt.atStartOfDay(ZoneId.systemDefault());
    // get epoch millis value
    data.add(createItem(z.toInstant().toEpochMilli()));
}