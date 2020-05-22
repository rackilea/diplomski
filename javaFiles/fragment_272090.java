Map<String, String> myMap = new HashMap<>();
myMap.put("d", "D");
myMap.put("c", "C");
myMap.put("b", "B");
myMap.put("A", "A");

List<String> myList = Arrays.asList("a", "b", "c");

Map<Boolean, Map<String, String>> result = myMap.entrySet()
        .stream()
        .collect(Collectors.partitioningBy(
                            entry -> myList.contains(entry.getKey()),
                            Collectors.toMap(Entry::getKey, Entry::getValue)
                    )
        );