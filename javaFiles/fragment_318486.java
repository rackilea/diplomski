public static void main(String args[]) {
    String currentDate = "02 MAY 2019";
    DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                                .parseCaseInsensitive()
                                .parseLenient()
                                .appendPattern("dd MMM yyyy")
                                // does not work without the Locale:
                                .toFormatter(Locale.ENGLISH); 
    DateTimeFormatter dtfIso = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate d = LocalDate.parse(currentDate, dtf);
    System.out.println(d.format(dtfIso));
}