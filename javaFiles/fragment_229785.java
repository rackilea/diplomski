Collection<String> largestCityNames = txcArray.stream()
        .collect(Collectors.groupingBy(
                City::getCounty,
                Collectors.collectingAndThen(
                        Collectors.maxBy(City::getPopulation),
                        o -> o.get().getName())))
        .values();