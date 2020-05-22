static Clock appClock = Clock.systemDefaultZone();

public static int getAge(LocalDate birthdate) { 
  LocalDate today = LocalDate.now(appClock);
  Period period = new Period(birthdate, today, PeriodType.yearMonthDay());
  return period.getYears(); 
}