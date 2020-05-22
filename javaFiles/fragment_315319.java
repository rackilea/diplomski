static void processSubsets(int[] set, int k) {
    int[] subset = new int[k];
    processLargerSubsets(set, subset, 0, 0);
}

static void processLargerSubsets(int[] set, int[] subset, int subsetSize, int nextIndex) {
    if (subsetSize == subset.length) {
        process(subset);
    } else {
        for (int j = nextIndex; j < set.length; j++) {
            subset[subsetSize] = set[j];
            processLargerSubsets(set, subset, subsetSize + 1, j + 1);
        }
    }
}