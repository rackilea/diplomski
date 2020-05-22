List<Article> list = Arrays.asList(
            new Article("2018-09-01", "2018-09-30"),
            new Article("2018-10-01", "2018-10-05"),
            new Article("2017-12-31", "2018-11-30"),
            new Article("2018-12-01", "2019-10-01"),
            new Article("2018-12-30", "2018-12-31"),
            new Article("2018-11-30", "2018-12-01"));

    LocalDate userDate = LocalDate.parse("2018-12-01");
    LocalDate userEnd = LocalDate.MAX;

    for(Article param : list) {
        LocalDate paramStart = param.getStartDateValidity();
        LocalDate paramEnd = param.getEndDateValidity();

        if (! (paramEnd.isBefore(userDate) || paramStart.isAfter(userEnd))) {
            System.out.println("Included " + param);
        }
    }