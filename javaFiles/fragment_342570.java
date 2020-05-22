public static void main(String args[]) throws Exception {
    // create a custom formatter for your pattern       
    DateTimeFormatter euroDtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    // receive today's date
    LocalDate today = LocalDate.now();
    // parse a date that has the form of your pattern using your custom formatter
    LocalDate parsedDate = LocalDate.parse("31-07-2019", euroDtf);

    System.out.println("Today is " + today.format(euroDtf));
    System.out.println("Parsed date is " + parsedDate.format(euroDtf));
}