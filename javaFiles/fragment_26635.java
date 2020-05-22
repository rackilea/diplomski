DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE;
// parse input
TemporalAccessor parsed = formatter.parse("2018-04-19+02:00");

// get data from the parsed object
LocalDate date = LocalDate.from(parsed);
ZoneId zone = ZoneId.from(parsed);
ZonedDateTime restored = date.atStartOfDay(zone); // 2018-04-19T00:00+02:00