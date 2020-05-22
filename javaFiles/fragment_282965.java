Map<Integer,Country> countryById = countries.stream()
    .collect(Collectors.toMap(Country::getCountryId, Function.identity()));
Map<Integer,Set<City>> citiesByStateId = cities.stream()
    .collect(Collectors.groupingBy(City::getStateId, Collectors.toSet()));

Map<Country, Map<State, Set<City>>> mapThatYouWant = states.stream()
    .collect(Collectors.groupingBy(s -> countryById.get(s.getCountryId()),
        Collectors.toMap(Function.identity(),
            s -> citiesByStateId.getOrDefault(s.getStateId(), Collections.emptySet()))));