public static Map<String, Set<String>> group(List<String> lines) {
    final Pattern comma = Pattern.compile(",\\s*");
    Map<String, Set<String>> map = new TreeMap<>();

    lines.stream()
        .map(comma::split)
        .forEach(line -> map.compute(line[0], (region, neighbors) -> {
            neighbors = neighbors != null ? neighbors : new TreeSet<>();
            neighbors.add(line[1]);
            return neighbors;
        }));

    return map;
}