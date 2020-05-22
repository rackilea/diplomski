public Date(int cMonth, int cDate, int cYear, int cDayToDate, String cStrMonth, int dayYear) {
    if (Arrays.asList(1, 3, 5, 7, 8, 10, 12).contains(cMonth)) {
        if (cDate > 31)
            throw new IllegalArgumentException();

    } else if (Arrays.asList(4, 6, 9, 11).contains(cMonth)) {
        if (cDate > 30)
            throw new IllegalArgumentException();

    } else if (cMonth == 2) {
        int days = isLeapYear(cYear) ? 29 : 28;
        if (cDate > days)
            throw new IllegalArgumentException();
    } else {
            throw new IllegalArgumentException();
    }
    date = cDate;
}