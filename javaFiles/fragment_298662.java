public static boolean isEven(String s) {
    if (s.isEmpty()) {
        return true;
    }
    Map<Integer, Long> counts = s.chars()
            .boxed()
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    Long someCount = counts.values().iterator().next();
    return counts.values()
            .stream()
            .allMatch(someCount::equals);
}