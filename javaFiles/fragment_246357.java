DateTime startDate = new DateTime().minusYears(10);
  DateTime endDate = new DateTime();
  Period p = new Period(startDate, endDate, PeriodType.standard().withYearsRemoved())
     .normalizedStandard(PeriodType.standard().withYearsRemoved());
  p.getMonths(); // throw exception, difference is 10 years!  

  DateTime startDate = new DateTime().minusMonths(10);
  DateTime endDate = new DateTime();
  Period p = new Period(startDate, endDate, PeriodType.standard().withYearsRemoved())
     .normalizedStandard(PeriodType.standard().withYearsRemoved());
  p.getMonths(); // return 10, difference is less then 1 year  

  DateTime startDate = new DateTime().minusYears(10);
  DateTime endDate = new DateTime();
  Period p = new Period(startDate, endDate, PeriodType.standard().withYearsRemoved());
  p.getMonths(); // return 120, standart isn't normalized