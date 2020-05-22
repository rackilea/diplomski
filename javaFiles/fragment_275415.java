// set with custom timezone names
Set<ZoneId> set = new HashSet<>();
// when parsing, ambiguous EST uses to New York
set.add(ZoneId.of("America/New_York"));

DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // append pattern, with optional offset (delimited by [])
    .appendPattern("EEE, d MMM yyyy HH:mm:ss[ Z]")
    // append optional timezone name with custom set for EST
    .optionalStart().appendLiteral(" ").appendZoneText(TextStyle.SHORT, set).optionalEnd()
    // create formatter using English locale to make sure it parses weekdays and month names correctly
    .toFormatter(Locale.ENGLISH);

ZonedDateTime est = ZonedDateTime.parse("Sat, 10 Jun 2017 12:49:45 EST", fmt);
ZonedDateTime utc = ZonedDateTime.parse("Sun, 11 Jun 2017 18:18:23 +0000", fmt);
System.out.println(est); // 2017-06-10T12:49:45-04:00[America/New_York]
System.out.println(utc); // 2017-06-11T18:18:23Z