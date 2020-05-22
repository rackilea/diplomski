public static Integer findClosestButNotLess(int value, Map<Integer, ?> map) {
    return map.keySet()
              .stream()
              .sorted().filter(k -> k >= value)
              .findFirst()
              .orElse(null);
}