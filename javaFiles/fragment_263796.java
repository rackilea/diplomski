private static Pattern p = Pattern
        .compile("(\\d+)d\\s+(\\d+)h\\s+(\\d+)m\\s+(\\d+)s");

/**
 * Parses a duration string of the form "98d 01h 23m 45s" into milliseconds.
 * 
 * @throws ParseException
 */
public static long parseDuration(String duration) throws ParseException {
    Matcher m = p.matcher(duration);

    long milliseconds = 0;

    if (m.find() && m.groupCount() == 4) {
        int days = Integer.parseInt(m.group(1));
        milliseconds += TimeUnit.MILLISECONDS.convert(days, TimeUnit.DAYS);
        int hours = Integer.parseInt(m.group(2));
        milliseconds += TimeUnit.MILLISECONDS
                .convert(hours, TimeUnit.HOURS);
        int minutes = Integer.parseInt(m.group(3));
        milliseconds += TimeUnit.MILLISECONDS.convert(minutes,
                TimeUnit.MINUTES);
        int seconds = Integer.parseInt(m.group(4));
        milliseconds += TimeUnit.MILLISECONDS.convert(seconds,
                TimeUnit.SECONDS);
    } else {
        throw new ParseException("Cannot parse duration " + duration, 0);
    }

    return milliseconds;
}