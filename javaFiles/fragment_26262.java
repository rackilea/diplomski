public static Integer findClosestButNotLess(int value, Map<Integer, ?> map) {
    return map.keySet()
              .stream()
              .filter(k -> k >= value)
              .min(Comparator.naturalOrder())
              .orElse(null);
}