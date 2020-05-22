DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    List<String> dates = Arrays.asList("31/05/2018", "19/06/2018", "01/07/2018");
    String dateIns = dates.get(0);
    dateIns = dateIns.replaceAll("\n", "");

    LocalDate todayDate = LocalDate.now(ZoneId.of("Pacific/Rarotonga"));
    LocalDate deadline = LocalDate.parse(dateIns, dateFormatter).minusWeeks(1);
    if (todayDate.isBefore(deadline)) {
        System.out.println("I Love My Car. Краен срок! Изтичащ преглед.");
    }