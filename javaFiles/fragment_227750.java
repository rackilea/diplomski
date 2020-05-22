if (dateFromFile.equals("00/00/00")) {
        System.out.println("0000-00-00");
    } else {
        System.out.println(LocalDate.parse(dateFromFile, 
                                           DateTimeFormatter.ofPattern("MM/dd/yy")));
    }