LocalDate date = LocalDate.of(2017, 9, 16);
// use ISO definition (Monday is the first day of week)
WeekFields wf = WeekFields.ISO;
LocalDate sundayInSameWeek = date
    // get the first day of this week
    .with(wf.dayOfWeek(), 1)
    // get next Sunday (or the same date, if it's already Sunday)
    .with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
System.out.println(sundayInSameWeek); // 2017-09-17