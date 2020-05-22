public static boolean isLeapYear(int year) {
    // assume Gregorian calendar for all time
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

public int getDays(int year) {
    return days + (this == FEB && isLeapYear(year) ? 1 : 0);
}