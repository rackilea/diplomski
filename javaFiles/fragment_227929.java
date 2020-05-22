public static void main(String[] args) {
    String datum = "20130419233512";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("Europe/Berlin"));
    ZonedDateTime datetime = ZonedDateTime.parse(datum, formatter);

    System.out.println(datetime.getZone()); // prints "Europe/Berlin"
    System.out.println(datetime.getOffset()); // prints "+02:00" (for this time of year)
}