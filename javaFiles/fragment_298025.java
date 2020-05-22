public static int findIndex(int[] values, int valueToSearch) {
    // No values to search through
    if (values == null || values.length == 0) {
        return -1;
    }

    // Iterate all values
    for (int i = 0; i < values.length; i++) {
        if (values[i] == valueToSearch) {
            return i;
        }
    }

    // All values were iterated, value was not found
    return -1;
}