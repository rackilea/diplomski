int[][] weights = ...
// Every entry yields two
int[][] resultWeights = new int[weights.length * 2][];

// Iterate all entries
int i = 0;
for (int[] entry : weights) {
    // Copy entry
    resultWeights[i] = entry;
    i++;
    // Other version
    resultWeights[i] = new int[] { entry[1], entry[0], entry[2] };
    i++;
}