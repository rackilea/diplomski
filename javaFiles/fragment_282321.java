private static int findSubArrays(int... array) {
    Arrays.sort(array);

    int sequenceCount = 0;
    int total = 0;
    for (int i = 0; i < array.length + 1; i++) {
        if (i == array.length || (i > 0 && array[i] != array[i - 1])) {
            total += triangle(sequenceCount);
            sequenceCount = 0;
        }
        sequenceCount++;
    }
    return total;
}

private static int triangle(int n) {
    return (n * (n + 1)) / 2;
}