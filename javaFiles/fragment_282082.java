/**
 *
 * @param startingDay - day of the week starting point ( need to be between 0-6 )
 * @param noDays number of days to count
 * @return result Day of the week
 */
private static WeekDays getWeekDay(int startingDay, int noDays){
    int dayNr = noDays % 7;
    int finalDayNr = (startingDay + dayNr) % 7;
    return WeekDays.values()[finalDayNr];
}

private static enum WeekDays {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}