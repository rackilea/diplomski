DateTimeFormatter yyyyMmDd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    int[] yearsToTest = { -900_000_000, -10_000, -2, 0, 1, 2017, 2099, 9999, 10_000, 900_000_000 };
    for (int year : yearsToTest) {
        LocalDate date = LocalDate.of(year, Month.DECEMBER, 2);
        String dateFormattedIso = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String dateFormattedYyyyMmDd = date.format(yyyyMmDd);
        String diff = dateFormattedIso.equals(dateFormattedYyyyMmDd) ? "Same" : "Different";
        System.out.format("%-18s%-18s%s%n", dateFormattedIso, dateFormattedYyyyMmDd, diff);
    }