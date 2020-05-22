Map<String, List<String>> xhashMap;
// always initialize the map to a non-null reference

xhashMap.getOrDefault("ax", Collections.emptyList())
        .forEach(v -> method1(v, AA.class));
xhashMap.getOrDefault("bx", Collections.emptyList())
        .forEach(v -> method1(v, BB.class));