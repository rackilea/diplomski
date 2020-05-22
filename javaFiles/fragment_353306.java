public Integer search(int[] array) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int a : array) {
        int count = counts.getOrDefault(a, 0);
        count++;
        if (count == 2) {
            return a;
        }
        counts.put(a, count);
    }
    return null;
}