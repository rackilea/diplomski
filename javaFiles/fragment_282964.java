Map<Country, Map<State, Set<City>>> mapThatYouWant = countries.stream()                
    .collect(Collectors.toMap(Function.identity(), c->states.stream()
        .filter(s -> Objects.equals(s.getCountryId(), c.getCountryId()))
        .collect(Collectors.toMap(Function.identity(), s->cities.stream()
            .filter(city -> Objects.equals(city.getStateId(), s.getStateId()))
            .collect(Collectors.toSet())))));