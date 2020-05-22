public static void main(final String... args)
{
    final Map<String, String> map = new HashMap<>();
    map.put("hello", "world");
    map.put("foo", "bar");

    // Create a map entry
    final Map.Entry<String, String> entry
        = new AbstractMap.SimpleEntry<>("foo", "bar");

    // Remove it from the set
    map.entrySet().remove(entry);
    System.out.println("after removing entry: " + map);

    // Remove a key
    map.keySet().remove("hello");
    System.out.println("after removing key: " + map);
}