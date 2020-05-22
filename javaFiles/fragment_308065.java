Map<String, Entry> resultSet = myMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().getId()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (left, right) -> left,
                        LinkedHashMap::new));