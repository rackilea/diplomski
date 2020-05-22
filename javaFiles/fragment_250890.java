private static int countChains(int[] bulbs) {
    int max = 0;
    int count = 0;
    for (int i=0; i<bulbs.length; i++) {
        if (bulbs[i] > max) {
            max = bulbs[i];
        }
        if (max == i+1) { // +1 because of 0-index based arrays
            count++;
        }
    }
    return count;
}