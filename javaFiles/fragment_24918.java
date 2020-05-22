infoMap.entrySet().stream()
       .map(e -> new SimpleEntry<>(e.getKey(),
                                   e.getValue().stream()
                                    .mapToDouble(d -> d).average()
                                    .orElse(0d)))
       .sorted(Comparator.comparingDouble(Entry::getValue))
       .collect(Collectors.toMap(Entry::getKey, Entry::getValue, 
                                (v1, v2) -> v1, LinkedHashMap::new));