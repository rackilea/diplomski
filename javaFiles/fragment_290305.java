private static void printIndexOfFirstRepeated(int ... values) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < values.length; i++)
        if (! set.add(values[i])) { // add() returns false if value already in set
            System.out.println("Index of first repeated: " + i);
            return;
        }
    System.out.println("No repeat found");
}
private static void printIndexOfRepeatedFirst(int ... values) {
    Map<Integer, Integer> mapValueToIndex = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
        Integer prevIndex = mapValueToIndex.put(values[i], i); // put() returns old value, or null
        if (prevIndex != null) {
            System.out.println("Index of repeated first: " + prevIndex);
            return;
        }
    }
    System.out.println("No repeat found");
}
private static void printFirstIndexOfRepeated(int ... values) {
    Integer firstIndex = null;
    Map<Integer, Integer> mapValueToIndex = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
        Integer prevIndex = mapValueToIndex.put(values[i], i); // put() returns old value, or null
        if (prevIndex != null && (firstIndex == null || prevIndex < firstIndex))
            firstIndex = prevIndex;
    }
    if (firstIndex != null)
        System.out.println("First index of repeated: " + firstIndex);
    else
        System.out.println("No repeat found");
}