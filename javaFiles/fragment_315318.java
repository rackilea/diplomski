processSubset(int[] set) {
    int subset = new int[2];
    for (int i = 0; i < set.length; i++) {
        subset[0] = set[i];
        processLargerSets(set, subset, i);
    }
}

void processLargerSets(int[] set, int[] subset, int i) {
    for (int j = i + 1; j < set.length; j++) {
        subset[1] = set[j];
        process(subset);
    }
}