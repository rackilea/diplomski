Map<Integer, String> sortedMap = 
     myMap.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue())
          .collect(Collectors.toMap(Map.Entry::getKey,
                                    Map.Entry::getValue, 
                                    (a, b) -> a, //or throw an exception
                                    LinkedHashMap::new));