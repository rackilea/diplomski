private static void split(NaturalNumber n) {
    int z = n.divideBy10();
    int y = n.divideBy10();

    if (n.isZero()) {
        // Base case.
        int result = (y * 10 + z) / 2;
        n.multiplyBy10(result / 10);
        n.multiplyBy10(result % 10);
    } else if (y % 2 == 0) {
        n.multiplyBy10(y);
        split(n);
        n.multiplyBy10(z / 2);
    } else {
        n.multiplyBy10(y - 1);
        split(n);
        n.multiplyBy10((10 + z) / 2);
    }
}