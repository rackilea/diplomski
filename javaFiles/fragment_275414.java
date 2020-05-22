// mapping EST to some other timezone (I know it's wrong and Chicago is not EST, it's just an example)
Map<String, DateTimeZone> map = new LinkedHashMap<>();
map.put("EST", DateTimeZone.forID("America/Chicago"));
// parser for my custom map
DateTimeParser customTimeZoneParser = new DateTimeFormatterBuilder().appendTimeZoneShortName(map).toParser();
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // append common pattern
    .appendPattern("EEE, d MMM yyyy HH:mm:ss ")
    // optional offset
    .appendOptional(offsetParser)
    // optional custom timezone name
    .appendOptional(customTimeZoneParser)
    // optional timezone name (accepts all others that are not in the map)
    .appendOptional(zoneNameParser)
    // create formatter (use English Locale to make sure it parses weekdays and month names independent of JVM config)
    .toFormatter().withLocale(Locale.ENGLISH)
    // make sure the offset "+0000" is parsed
    .withOffsetParsed();
System.out.println(fmt.parseDateTime("Sat, 10 Jun 2017 12:49:45 EST"));