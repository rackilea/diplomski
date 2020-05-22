LocalDate today = LocalDate.now();

TemporalAdjuster adjuster = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
LocalDate monday = today.with(adjuster);

System.out.println(today + " -> " + monday);