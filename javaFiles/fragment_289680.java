Map<Identifier1, Map<DateTimeRange, Usage>> t = /* ... */;
Map<Period, DateTimeRange> u = /* ... */;

BiFunction<Map<Identifier1, Map<DateTimeRange, Usage>>,
           Map<Period, DateTimeRange>,
           Map<Period, Map<Identifier1, Map<DateTimeRange, Usage>>>
           > filter = getPeriodFilter();
Map<Period, Map<Identifier1, Map<DateTimeRange, Usage>>> r = filter.apply(t, u);