// Format for input
DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
// Parsing the date
LocalDate date = LocalDate.parse(dateTime, inputFormat);
// Format for output
DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
// Printing the date
System.out.println(date.format(outputFormat));