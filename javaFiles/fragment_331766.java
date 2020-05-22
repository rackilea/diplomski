List<StringWithDateTime> listWithDateTimes = Arrays.asList(
                new StringWithDateTime("02/08/2017 13:00 198"),
                new StringWithDateTime("02/7/2018 08:00 75"),
                new StringWithDateTime("04/12/2014 19:00 5")
            );
    Collections.sort(listWithDateTimes);
    listWithDateTimes.forEach(System.out::println);