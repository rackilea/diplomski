String inputExample = "2017-06-28 22:44:55";
// parser for input
DateTimeFormatter parser = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
// parse the date and set to UTC
ZonedDateTime z = LocalDateTime.parse(inputExample, parser).atZone(ZoneOffset.UTC);

// map of custom values - map each numeric value to its string with suffix (st, nd...)
Map<Long, String> textLookup = new HashMap<Long, String>();
for (int i = 1; i <= 31; i++) {
    String suffix = "";
    switch (i) {
    case 1:
    case 21:
    case 31:
        suffix = "st";
        break;
    case 2:
    case 22:
        suffix = "nd";
        break;
    case 3:
    case 23:
        suffix = "rd";
        break;
    default:
        suffix = "th";
    }
    textLookup.put((long) i, i + suffix);
}
// output formatter
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // day of week
    .appendPattern("EEEE ")
    // append day with suffix (use map of custom values)
    .appendText(ChronoField.DAY_OF_MONTH, textLookup)
    // rest of pattern
    .appendPattern(" MMMM yyyy HH:mm")
    // create formatter with English locale
    .toFormatter(Locale.ENGLISH);

// print date, convert it to device default timezone
System.out.println(fmt.format(z.withZoneSameInstant(ZoneId.systemDefault())));