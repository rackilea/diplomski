private Calendar workingDaysBack(final Calendar from, final int count) {
    for (int daysBack = 0; daysBack < count; ++daysBack) {
        do {
            from.add(Calendar.DAY_OF_YEAR, -1);
        } while(isWeekend(from));
    }
    return from;
}

private boolean isWeekend(Calendar cal) {
    return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
           cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
}