....
// New York timezone
ZoneId ny = ZoneId.of("America/New_York");
// today in New York timezone
LocalDate today = LocalDate.now(ny);
// loop through the days
for (int day = 1; day <= lastDay; day++) {
    // create the day
    LocalDate dt = ym.atDay(day);
    if (dt.isBefore(today)) {
        // set to midnight at New York timezone
        ZonedDateTime z = dt.atStartOfDay(ny);
        ....