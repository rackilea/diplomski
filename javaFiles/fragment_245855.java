/*

    1900-1-0            0
    1900-1-1            1
    1900-1-2            2
    1900-1-3            3


     */


    int days = 43323;
    LocalDate start = LocalDate.of(1900, 1, 1);
    LocalDate today = LocalDate.of(2018, 8, 11);


    // days to date
    LocalDate date = start.plusDays(days).minusDays(2);

    System.out.println(date);

    // date to days
    long days1 = ChronoUnit.DAYS.between(start, today) + 2;
    System.out.println(days1);