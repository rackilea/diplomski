double sum(double[] array, int startInclusive, int endExclusive) {
    int distance = endExclusive - startInclusive;
    if (distance < 1000) {
        double total = 0;
        for (int i = startInclusive; i < endExclusive; ++i) {
            total += array[i];
        }
        return total;
    } else {
        int middle = startInclusive + distance / 2;
        var left = async sum(array, startInclusive, middle);
        var right = async sum(array, middle, endExclusive);
        return await left + await right;
    }
}