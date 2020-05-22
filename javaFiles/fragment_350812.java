static boolean contains(int element, int[][] cache) {
    for (int i = 0; i < cache.length; i++) {
        for (j = 0; j < cache[i].length; j++) {
            if (cache[i][j] == element) {
                return true;
            }
        }
    }
    return false;
}