public static void main(String... args) {
    String seq = "cat 10 hen 10 cat 10 gun 10 hen 10 lion 10 owl 10 pig 10";

    // [cat, 10, hen, 10, cat, 10, gun, 10, hen, 10, lion, 10, owl, 10, pig, 10]
    String[] splitEntries = seq.split(" ");

    Map<String, Integer> myMap = new HashMap<>();
    for (int i = 0; i < splitEntries.length - 1; i += 2) {
        // Iterate on splitEntries incrementing i by 2, so we can store the pairs:
        // (0, 1), (2, 3), (4, 5), etc.
        String key = splitEntries[i];
        Integer value = Integer.valueOf(splitEntries[i + 1]);
        // Pass Integer::sum so the previous value will be summed with the new one
        // when trying to insert a repeated key
        myMap.merge(key, value, Integer::sum);
    }
    System.out.println(myMap);
}