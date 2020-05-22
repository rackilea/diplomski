public static TemporalAdjuster nextNthDayOfWeek(int n, DayOfWeek dayOfWeek) {
    return temporal -> {
        Temporal next = temporal.with(TemporalAdjusters.next(dayOfWeek));
        return next.plus(n - 1, ChronoUnit.WEEKS);
    };
}