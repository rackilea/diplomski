private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d-M-uuuu");

public static void printWorkWeeksOfMonth(String date) {
    LocalDate ld = LocalDate.parse(date, DATE_FORMAT);
    LocalDate lastDayOfMonth = ld.with(TemporalAdjusters.lastDayOfMonth());

    // find first working day of month; also first working day of first work week
    LocalDate firstWorkingDay = ld.withDayOfMonth(1);
    if (ld.getDayOfWeek() == DayOfWeek.SATURDAY || ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
        firstWorkingDay = firstWorkingDay.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
    while (! firstWorkingDay.isAfter(lastDayOfMonth)) {
        // find last working day of week beginning on firstWorkingDay
        LocalDate lastWorkingDay = firstWorkingDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        if (lastWorkingDay.isAfter(lastDayOfMonth)) {
            // end work week at end of month
            lastWorkingDay = lastDayOfMonth;
        }
        System.out.println(firstWorkingDay.format(DATE_FORMAT)
                + " through " + lastWorkingDay.format(DATE_FORMAT));

        // find beginning of next work week
        firstWorkingDay = firstWorkingDay.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
}