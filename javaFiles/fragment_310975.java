LocalDate ld = LocalDate.now(); // or the LocalDate.now(ZoneId) overload
int count = 0;
// first set the date to the next Friday first...
ld = ld.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
// this will find 10 such dates
while (count < 10) {
    if (isFriday13(ld)) { // implementation shown below
        count++;
        System.out.println(ld);
    }
    ld = ld.plusDays(7); // this set ld to be the next Friday
}