public int find(int[] route) {
    int max = 1;
    int currentMax = 1;
    for (int i = 0; i < route.length - 1; i++) {
        if (route[i] > route[i + 1]) {
            currentMax++;    // If next element is lower increment currentMax
            if (currentMax > max) {
                max = currentMax;   // If currentMax is the new max update max
            }

        } else {
            currentMax = 1;   // If next element is not lower restart from 1
        }
    }
    return max;
}