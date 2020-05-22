class DateTimeTester {
  ---
  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("+yyyy-MM-dd'T'HH:mm:ss'Z'")
        .withZone(ZoneId.of("UTC"));
    LocalDateTime date = LocalDateTime.parse("+2017-02-26T01:02:03Z", formatter);
    System.out.println(date);
  }
}