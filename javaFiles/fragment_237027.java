myMap.entrySet().stream()
        .sorted(comparingByValue(reverseOrder()))
        .collect(toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (x,y)-> {throw new AssertionError();},
                LinkedHashMap::new
        ));