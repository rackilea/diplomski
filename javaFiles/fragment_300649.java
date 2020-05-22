// today, but make sure you consider time-zones when using this method
LocalDate today = LocalDate.now();

// find the next Sunday
LocalDate endSun = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

// find 3 months earlier (there are 13 weeks in 3 months)
LocalDate startSun = endSun.minusWeeks(13);

// find dates
Stream<LocalDate> dates = startSun.datesUntil(endSun, Period.ofWeeks(1));