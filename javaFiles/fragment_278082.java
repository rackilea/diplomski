static int eval(int[] a) {
    int[] inputsPerResidue = new int[11];
    for (int i : a) {
        inputsPerResidue[i % 11]++;
    }
    int maxGroupSize = 0;
    for (int groupSize : inputsPerResidue) {
        if (groupSize > 1 && groupSize > maxGroupSize) {
            maxGroupSize = groupSize;
        }
    }
    return maxGroupSize;
}