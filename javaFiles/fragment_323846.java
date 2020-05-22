String dateString = "2018-09-31";

    try {
        LocalDate.parse(dateString);
    } catch (DateTimeParseException dtpe) {
        System.out.println(dtpe);
    }