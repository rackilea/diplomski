Seconds s1 = Seconds.seconds(3601);
    Seconds s2 = Seconds.seconds(2000);
    Seconds s3 = Seconds.seconds(898298);
    Period p1 = new Period(s1);
    Period p2 = new Period(s2);
    Period p3 = new Period(s3);

    PeriodFormatter dhm = new PeriodFormatterBuilder()
        .appendDays()
        .appendSuffix(" day", " days")
        .appendSeparator(" and ")
        .appendHours()
        .appendSuffix(" hour", " hours")
        .appendSeparator(" and ")
        .appendMinutes()
        .appendSuffix(" minute", " minutes")
        .appendSeparator(" and ")
        .appendSeconds()
        .appendSuffix(" second", " seconds")
        .toFormatter();

    System.out.println(dhm.print(p1.normalizedStandard()));
    System.out.println(dhm.print(p2.normalizedStandard()));
    System.out.println(dhm.print(p3.normalizedStandard()));