public int find(int[] route, int start, int max, int currentMax) {
    if (currentMax > max) {
        max = currentMax;
    }
    if (start == route.length - 1) {
        return max;
    }
    if (route[start] > route[start + 1]) {
        return find(route, start + 1, max, currentMax + 1);
    }
    return find(route, start + 1, max, 1);
}