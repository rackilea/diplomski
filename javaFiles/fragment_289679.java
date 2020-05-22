public static <K extends Identifier> BiFunction<
            Map<K, Map<DateTimeRange, Usage>>,
            Map<Period, DateTimeRange>,
            Map<Period, Map<K, Map<DateTimeRange, Usage>>>
        > getPeriodFilter() {
    return (usageMap, timeRangeMap) -> /* do something */;
}