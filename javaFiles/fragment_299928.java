public LocalDate add(LocalDate date, int workdays) {
    if (workdays < 1) {
        return date;
    }

    LocalDate result = date;
    int addedDays = 0;
    while (addedDays < workdays) {
        result = result.plusDays(1);
        if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
              result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            ++addedDays;
        }
    }

    return result;
}