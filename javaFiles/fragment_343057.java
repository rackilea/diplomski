private static void merge (int[] a, int[] firstHalf, int[] lastHalf) {

    int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;
    while ((firstHalfIndex < firstHalf.length) && (lastHalfIndex < lastHalf.length)) {
        if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex]) {
            a[aIndex] = firstHalf[firstHalfIndex];
            firstHalfIndex++;
        } else {
            a[aIndex] = lastHalf[lastHalfIndex];
            lastHalfIndex++;
        }
        aIndex++;
    }
    while (firstHalfIndex < firstHalf.length) {
        a[aIndex] = firstHalf[firstHalfIndex];
        aIndex++;
        firstHalfIndex++;
    }
    while (lastHalfIndex < lastHalf.length) {
        a[aIndex] = lastHalf[lastHalfIndex];
        aIndex++;
        lastHalfIndex++;
    }
}