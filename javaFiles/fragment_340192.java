....
// today
LocalDate today = LocalDate.now();
// loop through the days
for (int day = 1; day <= lastDay; day++) {
    // create the day
    LocalDate dt = ym.atDay(day);
    if (dt.isBefore(today)) {
        ....