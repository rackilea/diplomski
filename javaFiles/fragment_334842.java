public static Pair<Integer, Integer> getWeekSpan(LocalDate date) {
    return new Pair<>(getZeroBasedDayOfYear(date.with(DayOfWeek.MONDAY)),
            getZeroBasedDayOfYear(date.with(DayOfWeek.SUNDAY)));
}

private static int getZeroBasedDayOfYear(LocalDate date) {
    return date.getDayOfYear() - 1;
}