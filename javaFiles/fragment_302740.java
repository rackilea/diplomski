public void removeRange(Map<Integer, String> map, String from, String to) {
    // Walk each entry.
    for (Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator(); it.hasNext();) {
        // What is the value?
        String v = it.next().getValue();
        if (v.compareTo(from) > 0 && v.compareTo(to) < 0) {
            // In the specified range! Remove it.
            it.remove();
        }
    }

}

public void test() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "w");
    map.put(5, "x");
    System.out.println("Before:" + map);
    removeRange(map, "a", "x");
    System.out.println("After:" + map);
}