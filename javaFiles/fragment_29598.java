// parse the input
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // parse AM/PM and am/pm
    .parseCaseInsensitive()
    // input pattern
    .appendPattern("MM-dd-yyyy hh:mm:ss a")
    // use English locale for am/pm symbols
    .toFormatter(Locale.ENGLISH);
LocalDateTime dt = LocalDateTime.parse("09-23-2019 10:03:11 pm", fmt);
// convert to Hawaii timezone
ZonedDateTime hawaiiDate = dt.atZone(ZoneId.of("US/Hawaii"));