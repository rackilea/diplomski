public static void main(String[] args) {
    Map<List<String>, Integer> initial = new HashMap<>();

    initial.put(Arrays.asList("a"),           1);
    initial.put(Arrays.asList("a", "b", "c"), 5);
    initial.put(Arrays.asList("a", "c"),      3);
    initial.put(Arrays.asList("c"),           4);
    initial.put(Arrays.asList("b", "d"),      2);
    initial.put(Arrays.asList("b"),           1);
    initial.put(Arrays.asList("v", "w", "x", "y", "z"), 99);

    List<Map<List<String>, Integer>> result = new ArrayList<>(
        initial.entrySet() // Get an unordered collection of entries
            .stream()
            .collect(Collectors.groupingBy(
                e -> e.getKey().size(), // Group by word list size...
                TreeMap::new, // ...into a sorted map...
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue) // ... collecting all values with the same word count into individual Maps
            ))
            .values() // Construct our ArrayList using the ordered collection of map values
    );

    System.out.println(result); // Output: [{[a]=1, [b]=1, [c]=4}, {[a, c]=3, [b, d]=2}, {[a, b, c]=5}, {[v, w, x, y, z]=99}]
    // Note that the above result doesn't contain an empty Map ('{}') for 4-word lists
}