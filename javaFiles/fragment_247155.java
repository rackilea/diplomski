public static void main(String[] args) {
    Map<String, String[]> hm = new HashMap<>();

    addToMap(hm, "Zara", "Pony", "Cars", "Magic");
    addToMap(hm, "John", "Horse", "Flying", "Loving");
}

private static void addToMap
    (Map<String, String[]> map, String key, String... values) {
    map.put(key, values);
}