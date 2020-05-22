list.stream()
    .collect(Collectors.groupingBy(
        Person::getPersonId,
        Collectors.groupingBy(
            Person::getDate
)));