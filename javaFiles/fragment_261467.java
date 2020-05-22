final Map<String, Integer> counts = new HashMap<>();
for (final String s : list) {
    final Integer c = counts.get(s);
    if (c == null) {
        counts.put(s, 1);
    } else {
        counts.put(s, c + 1);
    }
}