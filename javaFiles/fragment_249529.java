String[] exampleStrings = {
            "2018-09-10T10:35:00.377Z",
            "2018-09-10T10:35:00.12Z",
            "2018-09-10"
    };

    for (String example : exampleStrings) {
        if (example.contains("T")) {
            OffsetDateTime dateTime = OffsetDateTime.parse(example);
            System.out.println("Date: " + dateTime.toLocalDate() 
                    + " Time: " + dateTime.toLocalTime() 
                    + " Offset: " + dateTime.getOffset());
        } else {
            LocalDate date = LocalDate.parse(example);
            System.out.println("Date: " + date);
        }
    }