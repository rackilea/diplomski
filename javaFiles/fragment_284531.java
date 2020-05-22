long millisSinceUnix =
    ChronoFormatter.ofPattern(
        "yyyyMMddHHmmssSSS",
        PatternType.CLDR,
        Locale.ROOT,
        Moment.axis(TemporalType.MILLIS_SINCE_UNIX)
    ).with(Timezone.ofSystem()).parse(mydate).longValue();
System.out.println(millisSinceUnix); // 1376336760025