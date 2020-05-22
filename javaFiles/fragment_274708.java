String input = "270317";
// parse the date
DateTimeFormatter parser = DateTimeFormatter.ofPattern("ddMMyy");
LocalDate date = LocalDate.parse(input, parser);

// locale specific format
DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
System.out.println(formatter.format(date));