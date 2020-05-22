PeriodFormatter pf = 
    new PeriodFormatterBuilder()
    .appendMinutes()
    .appendSuffix(" minute", " minutes")
    .toFormatter();
Period p = pf.parsePeriod("5 minutes");
System.out.println(p); // PT5M