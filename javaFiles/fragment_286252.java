public static boolean isDateInRange(int year, int month, int day,
                                    int yearFrom, int monthFrom, int dayFrom,
                                    int yearUntil, int monthUntil, int dayUntil) {

    GregorianCalendar testDate = new GregorianCalendar(year, month, day);
    GregorianCalendar startDate = new GregorianCalendar(yearFrom, monthFrom, dayFrom);
    GregorianCalendar endDate = new GregorianCalendar(yearUntil, monthUntil, dayUntil);

    return !(testDate.before(startDate) || testDate.after(endDate));
}