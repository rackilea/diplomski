Map<Integer, Integer> sum = _Test //<- type of key should be Integer, not String
        .stream()
        .collect(
            Collectors.groupingBy(
                Test::getAge, // <- grouping by age
                Collectors.summingInt(Test::getAmount) //<-use summingInt instead of summarizingInt
                                                       //  to sum amount attribute
            )
        );