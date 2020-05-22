time = time.entrySet()
           .stream()
           .sorted(Comparator.comparing(Map.Entry::getValue))
           .collect(Collectors.toMap(Map.Entry::getKey, 
                                    Map.Entry::getValue,
                                    (v1,v2)->v1,
                                    LinkedHashMap::new));