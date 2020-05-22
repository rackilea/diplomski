public static int daysBeforeMonth(int month, int year) {
    int Feb = 28;
    if (isLeapYear(year) == true) {
        month = 29;
    }
    if (month == 1) {
        return 0;
    } else if ... {
    } else if (month == 12) {
        return Feb + 306;
    }
    else {
        return 0;
    }
}