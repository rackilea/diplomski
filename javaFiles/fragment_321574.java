List<String> res = persons.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> e.getValue() == 1)
            .map(e -> e.getKey())
            .collect(Collectors.toList());

    System.out.println(res); // [Max, Greg]