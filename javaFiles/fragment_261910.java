Optional<String> optionalS =
Stream.of(new User("name1"), new User("name1"), new User("name2"), new User("name2"))
        .collect(Collectors.groupingBy(User::getLastName, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() >= 2)
        .reduce((e1, e2) -> e1.getValue() < e2.getValue()? e2:
                            e1.getValue() > e2.getValue()? e1:
                            new AbstractMap.SimpleImmutableEntry<>(null, e1.getValue()))
        .map(Map.Entry::getKey);

System.out.println(optionalS.toString());