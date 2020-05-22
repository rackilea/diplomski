System.out.print("Please enter Date: ");
String date = console.nextLine();
while(!date.matches("([0-9]{2})\\([0-9]{2})\\([0-9]{4})")) {
    System.out.println("Please enter correct date format");
    date = console.nextLine();
}

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse(date, formatter);