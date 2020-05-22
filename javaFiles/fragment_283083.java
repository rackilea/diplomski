Map<String, String> originalMap = getMapOfValues();
Map<String, String> newMap = 
    originalMap.entrySet()
               .stream()
               .collect(Collectors.toMap(Map.Entry::getKey,
                                         entry -> mapValue(entry.getValue())));