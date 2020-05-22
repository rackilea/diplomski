Duration duration = new Duration(durationInSecond * 1000);
PeriodFormatter formatter = new PeriodFormatterBuilder()
        .appendDays()
        .appendSuffix(" days, ")
        .appendHours()
        .appendSuffix(" hours, ")
        .appendMinutes()
        .appendSuffix(" minutes, ")
        .appendSeconds()
        .appendSuffix(" seconds")
        .toFormatter();

Period period = duration.toPeriod();
Period dayTimePeriod = period.normalizedStandard(PeriodType.dayTime());
String formattedString = formatter.print(dayTimePeriod);

System.out.println(formattedString);