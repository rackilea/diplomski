public static void main(String[] args) {
    List<Map<List<String>, Integer>> mapList = new ArrayList<>();

    put(mapList, Arrays.asList("a"),           1);
    put(mapList, Arrays.asList("a", "b", "c"), 5);
    put(mapList, Arrays.asList("a", "c"),      3);
    put(mapList, Arrays.asList("c"),           4);
    put(mapList, Arrays.asList("b", "d"),      2);
    put(mapList, Arrays.asList("b"),           1);

    System.out.println(mapList); // Output: [{[a]=1, [b]=1, [c]=4}, {[a, c]=3, [b, d]=2}, {[a, b, c]=5}]
}

private static void put(List<Map<List<String>, Integer>> mapList, List<String> words, Integer number) {
    assert !words.isEmpty() : "Must be at least one word in list";

    // First, make sure our list of maps is long enough for the word list we're adding
    while(mapList.size() < words.size()) {
        mapList.add(new HashMap<>());
    }

    // Now, add the words and number to the appropriate map
    mapList.get(words.size() - 1).put(words, number);
}