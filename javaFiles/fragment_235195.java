Map<Integer, Integer> result = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
            .filter(entry -> !filterUs.contains(entry.getKey()))
            .skip(1)
            .limit(50)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));