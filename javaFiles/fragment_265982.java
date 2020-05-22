/** Returns the maximum value in the array. */
private static int maximum(int[] array) {
    if (array.length == 0) {
        // You need to decide what to do here... throw an exception,
        // return some constant, whatever.
    }
    // Okay, so the length will definitely be at least 1...
    return maximumRecursive(array, array.length);
}

/** Returns the maximum value in array in the range [0, upperBoundExclusive) */
private static int maximumRecursive(int[] array, int upperBoundExclusive) {
    // We know that upperBoundExclusive cannot be lower than 1, due to the
    // way that this is called. You could add a precondition if you really
    // wanted.
    if (upperBoundExclusive == 1) {
        return array[0];
    }
    int earlierMax = maximumRecursive(array, upperBoundExclusive - 1);
    int topValue = array[upperBoundExclusive - 1];
    return Math.max(topValue, earlierMax);

    // Or if you don't want to use Math.max
    // return earlierMax > topValue ? earlierMax : topValue;
}