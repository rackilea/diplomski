long weekNumber = 1;
long dayOfWeek = 1;
int year = 2018;

LocalDate desiredDate = LocalDate.now()
    .withYear(year)
    .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
    .with(ChronoField.DAY_OF_WEEK, dayOfWeek );

System.out.println(desiredDate);