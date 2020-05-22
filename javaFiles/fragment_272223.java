public static void main(String[] args) {
    DateTimeZone EDT = DateTimeZone.forID("America/Toronto");
    DateTime start = new DateTime(2016, 5, 15, 4, 0, DateTimeZone.UTC);
    DateTime end = start.plusDays(2);

    int offset1 = (int) TimeUnit.MILLISECONDS.toMinutes(EDT.getOffset(start.getMillis()));
    int offset2  = (int) TimeUnit.MILLISECONDS.toMinutes(EDT.getOffset(end.getMillis()));
    if (offset1 != offset2) {
        end = end.plusMinutes(offset1 - offset2);
    }

    System.out.println(new Interval(start.toDateTime().withZone(EDT),
            end.toDateTime().withZone(EDT)));

}