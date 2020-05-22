try {
        System.out.println(LocalDate.parse(dateFromFile, 
                   DateTimeFormatter.ofPattern("MM/dd/yy")));
    } catch (DateTimeParseException dtpe) {
        System.out.println("0000-00-00");
    }