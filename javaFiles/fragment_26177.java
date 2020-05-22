public static void main(String[] args) {

    List<String> dates = Arrays.asList("Tue, 09 Feb 2016 14:07:00 GMT", "Tue, 09 Feb 2016 19:55:00 GMT");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    ZonedDateTime maxDate = dates.stream()
                                 .map(s -> ZonedDateTime.parse(s, formatter))
                                 .max(ZonedDateTime::compareTo)
                                 .get(); // or .orElse(null)

    System.out.println(maxDate);
}