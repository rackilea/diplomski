public Date(int cMonth, int cDate, int cYear, int cDayToDate, String cStrMonth, int dayYear) {
    switch (cMonth) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (cDate > 31)
                throw new IllegalArgumentException();
            break;

        case 4:
        case 6:
        case 9:
        case 11:
            if (cDate > 30)
                throw new IllegalArgumentException();
            break;
        case 2:
            int days = isLeapYear(cYear) ? 29 : 28;
            if (cDate > days)
                throw new IllegalArgumentException();
            break;
        default:
            throw new IllegalArgumentException();
    }
    date = cDate;
}