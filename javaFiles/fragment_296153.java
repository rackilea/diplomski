public static List<Date> dayRange(Date begin, Date end) {
    if (end.before(begin)) {
        throw new IllegalArgumentException("Invalid range");
    }

    final List<Date> range = new ArrayList<>();
    final Calendar c1 = extractDate(begin);
    final Calendar c2 = extractDate(end);

    while (c1.before(c2)) {
        range.add(c1.getTime()); // begin inclusive
        c1.add(Calendar.DATE, 1);
    }
    range.add(c2.getTime()); // end inclusive

    return range;
}

private static Calendar extractDate(Date date) {
    final Calendar c = Calendar.getInstance();

    c.setTime(date);
    c.set(Calendar.HOUR, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);

    return c;
}