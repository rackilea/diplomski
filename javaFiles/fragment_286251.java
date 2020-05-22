public static boolean isDateInRange(int month, int day,
                                    int monthFrom, int dayFrom,
                                    int monthUntil, int dayUntil) {
    int yearRoll = 0;
    int currentRoll = 0;
    if (monthUntil < monthFrom) yearRoll = -1; // Ensures date is calculated correctly.
    if (month >= monthFrom && yearRoll < 0) currentRoll = -1;

    GregorianCalendar testDate = new GregorianCalendar(currentRoll, month, day);
    GregorianCalendar startDate = new GregorianCalendar(yearRoll, monthFrom, dayFrom);
    GregorianCalendar endDate = new GregorianCalendar(0, monthUntil, dayUntil);

    // This makes it pass if its between OR EQUAL to the interval.
    // Remove if you only want to pass dates explicitly BETWEEN intervals.
    if (testDate.compareTo(startDate) == 0 || testDate.compareTo(endDate) == 0) {
        return true;
    }

    return !(testDate.before(startDate) || testDate.after(endDate));
}