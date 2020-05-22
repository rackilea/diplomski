String startDateString = "16/02/2006";

DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
LocalDate localDate = formatter.parseLocalDate(startDateString);
if (localDate.getYear() < 2006) {
    // code here
}