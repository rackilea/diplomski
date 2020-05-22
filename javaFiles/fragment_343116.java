LocalDate currentLocalDate = LocalDate.now();
int dayOfWeek = currentLocalDate.getDayOfWeek().getValue();
int weekOfYear = currentLocalDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
LocalDate resultLocalDate = currentLocalDate
    .minusYears(1)
    .with(ChronoField.ALIGNED_WEEK_OF_YEAR, weekOfYear)
    .with(ChronoField.DAY_OF_WEEK, dayOfWeek);