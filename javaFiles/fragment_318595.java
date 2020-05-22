List<Person> people = Arrays.asList(new Person("Steve", "wine"), new Person("Steve", "cola"),
            new Person("Ben", "cola"), new Person("Ben", "cola"), new Person("Steve", "wine"),
            new Person("Steve", "wine"));

    Map<Person, Long> map = people.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));