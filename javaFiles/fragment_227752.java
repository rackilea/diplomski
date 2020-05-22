DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("MM/dd/yy")
            .withResolverStyle(ResolverStyle.LENIENT);
    LocalDate unknownDateParsed = LocalDate.of(1999, Month.NOVEMBER, 30);
    LocalDate date = LocalDate.parse(dateFromFile, parseFormatter);
    if (date.equals(unknownDateParsed)) {
        System.out.println("0000-00-00");
    } else {
        System.out.println(date);
    }