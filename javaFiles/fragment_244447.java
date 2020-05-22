Set<Location> locationSet = Set.of(
        new Location("USA", "AZ", "Phoenix"),
        new Location("USA", "AZ", "Scottsdale"),
        new Location("USA", "AZ", "Peoria"),
        new Location("USA", "MD", "Baltimore"),
        new Location("USA", "MD", "Gaithersburg"),
        new Location("USA", "MD", "OwingsMills"),
        new Location("CA", "ON", "Toronto"));

Map<String, Map<String, List<String>>> countryMap = locationSet.stream()
        .collect(Collectors.groupingBy(Location::getCountry, TreeMap::new,
                Collectors.groupingBy(Location::getState, TreeMap::new,
                        Collectors.mapping(Location::getCity, Collectors.toList()))));

System.out.println(JSONWriter.valueToString(countryMap));