public int getClosest(int[] array, int input) {
    int lowestDiff = Integer.MAX_VALUE;
    int result = 0;
    for (int i : array) {
        int diff = Math.abs(input - i); // use API to get absolute diff
        if (diff < lowestDiff) {
            lowestDiff = diff;
            result = i;
        }
    }
    return result;
}