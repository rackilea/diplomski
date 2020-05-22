static int[][] cacheContaining(int element, List<int[][]> caches) {
    for (int[][] cache : caches) {
        if (contains(element, cache)) {
            return cache;
        }
    }
    return null;
}