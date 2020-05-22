String date = "04/2018";
DateTimeFormatter dateFormat = new DateTimeFormatterBuilder()
        .appendPattern("MM/yyyy")
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .toFormatter();
LocalDate parsedDate = LocalDate.parse(date, dateFormat);
System.out.println(parsedDate); // prints: 2018-04-01