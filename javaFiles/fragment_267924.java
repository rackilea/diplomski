Map<String, Set<String>> myMapOfSets = new HashMap<>();
myMapOfSets.put("K1", new HashSet<>(Arrays.asList("A", "B", "C",      "E"     )));
myMapOfSets.put("K2", new HashSet<>(Arrays.asList(     "B", "C", "D",      "F")));
myMapOfSets.put("K3", new HashSet<>(Arrays.asList("A",      "C",      "E", "F")));
myMapOfSets.put("K4", new HashSet<>(Arrays.asList(     "B", "C", "D"          )));
myMapOfSets.put("K5", new HashSet<>(Arrays.asList("A",      "C", "D"          )));
myMapOfSets.put("K6", new HashSet<>(Arrays.asList(     "B", "C", "D", "E", "F")));

List<Entry<String, Long>> result =           // change to List<String> if you only want values
        myMapOfSets.values()
                   .stream()
                   .flatMap(Set::stream)
                   .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                   .entrySet()
                   .stream()
                   .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // descending
                   .limit(3)                 // change to 10 for your code
                // .map(Map.Entry::getKey)   // uncomment if you only want values
                   .collect(Collectors.toList());
result.forEach(System.out::println);