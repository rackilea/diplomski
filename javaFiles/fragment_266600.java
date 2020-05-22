String itemNumber = "1234";

List<String> result = 
       myMap.values()
            .stream()
            .flatMap(Collection::stream)
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .filter(e -> e.getKey().equals(itemNumber))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());