HashMap<List<String>, String> pathMap;

pathMap.put(
    // unmodifiable so key cannot change hash code
    Collections.unmodifiableList(Arrays.asList("korey", "docs")),
    "/home/korey/docs"
);

// later:
String dir = pathMap.get(Arrays.asList("korey", "docs"));