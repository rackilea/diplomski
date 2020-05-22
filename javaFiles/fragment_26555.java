public static int countMax(int[] values) {
    // first, find the maximum value
    int maxValue = Integer.MIN_VALUE;
    for (int i = 0; i < values.length; ++i) {
        maxValue = Math.max(maxValue, values[i]);
    }

    // then count the maximum value
    int maxCount = 0;
    for (int i = 0; i < values.length; ++i) {
        if (values[i] == maxValue) maxCount++;
    }

    return maxCount;
}