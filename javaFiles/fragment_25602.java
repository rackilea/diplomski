String startDateString = "16/02/2006";

DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
LocalDate localDate = LocalDate.parse(startDateString, dateTimeFormatter);
if (localDate.getYear() < 2006) {
    // code here
}