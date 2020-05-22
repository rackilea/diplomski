availableCountries.stream()
    .filter(availableCountries::contains)       // Stream<Country> of qualified countries
    .map(country -> Optional                    // attempt to map each Cuntry to Domain
        .ofNullable(availableDomains)           // Optional<List<Domain>>
        .orElse(Collections.emptyList())        // or else an empty List
        .stream()
        .filter(availableDomain -> availableDomain.getName().equals(country.getCountry()))
        .findAny()
        .orElse(null))                          // if the name doesn't match, then null
    .filter(Objects::nonNull)                   // filter the nulls out
    .collect(Collectors.toList());              // and produce a List<Domain>