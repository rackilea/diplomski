public static void main(String[] args) {
    // Input data
    String[] players = {"a","b","c","d","e"};
    int[] goalsByPlayer = {3,0,0,4,0};

    // Put all of them into Map
    Map<String, Integer> unsortMap = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
        unsortMap.put(players[i], goalsByPlayer[i]);
    }

    System.out.println("Unsort Map......");
    printMap(unsortMap);

    // Sort by value with reverse order
    Map sorted = unsortMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    System.out.println("\nSorted Map......By Value");
    printMap(sorted);
}

// print a map
public static <K, V> void printMap(Map<K, V> map) {
    for (Map.Entry<K, V> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey()
            + " Value : " + entry.getValue());
    }
}