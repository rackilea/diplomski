Map<int[], Integer> map = new HashMap<>();
map.put(new int[] {0, 0}, 0);
map.put(new int[] {0, 1}, 1);
map.put(new int[] {1, 0}, 2);
map.put(new int[] {1, 1}, 3);

return map.entrySet().stream()
        .filter(e -> e.getKey()[0] == counterFlag)
        .filter(e -> e.getKey()[1] == priorityEnable)
        .map(Map.Entry::getValue)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);