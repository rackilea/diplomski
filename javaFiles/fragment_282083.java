/**
 *
 * @param startingDay
 *            - day of the week starting point ( need to be between 0-6 )
 * @param noDays
 *            number of days to count
 * @return result Day of the week
 */
private static String getWeekDay(int startingDay, int noDays) {
    int dayNr = noDays % 7;
    int finalDayNr = (startingDay + dayNr) % 7;
    return getDay(finalDayNr);
}

private static String getDay(int dayNr) {
    switch (dayNr) {
    case 0:
        return "SUNDAY";
    case 1:
        return "MONDAY";
    case 2:
        return "TUESDAY";
    case 3:
        return "WEDNESDAY";
    case 4:
        return "THURSDAY";
    case 5:
        return "FRIDAY";
    case 6:
        return "SATURDAY";
    }
    throw new IllegalArgumentException("Wrong input. Day nr must be between 0-6.");
}