public static int getFinalYear(int digit) {
    int year = 2013;
    int finalYear = year;
    int lastYear = year % 10;
    if (digit > lastYear) {
        finalYear += (digit - lastYear) - 10;
    } else {
        finalYear -= lastYear - digit;
    }
    return finalYear;
}