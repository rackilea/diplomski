List<VegetableMaker> dbObjects = List.of(
            new VegetableMaker("Salad", List.of("Onion", "Cucumber")),
            new VegetableMaker("Italian Salad", List.of("Cheese")),
            new VegetableMaker("Greek Salad", List.of("Onion")));

    Map<String, List<VegetableMaker>> map = dbObjects.stream()
            .flatMap(x -> x.getVegetableList().stream().map(y -> new SimpleEntry<>(x, y)))
            .collect(Collectors.groupingBy(
                    Entry::getValue,
                    Collectors.mapping(Entry::getKey, Collectors.toList())));

    System.out.println(map);