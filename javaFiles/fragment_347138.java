// 1 month, 2 weeks and 2 days
Period p = new Period(0, 1, 2, 2, 0, 0, 0, 0);

PeriodFormatter fmt = new PeriodFormatterBuilder()
    // months
    .appendMonths().appendSuffix(" month", " months").appendSeparator(" and ")
    // days
    .appendDays().appendSuffix(" day", " days")
    .toFormatter();
System.out.println(fmt.print(p.normalizedStandard(PeriodType.yearMonthDayTime())));