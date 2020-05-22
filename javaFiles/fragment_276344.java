Map<Integer, Double> totalAgeByGender = // not Map<Integer, Integer>
    roster.stream()
        .collect(Collectors.groupingBy(
            Person::getGender,
            Collectors.reducing(
                0d, // not 0
                Person::getAge,
                Double::sum)));