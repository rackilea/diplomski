public static int what(int[] a) {
    if (a.length == 0) {
        return 0;
    }

    int sumLeft = 0, sumRight = 0;
    for (int el : a) {
        sumRight += el % 3;
    }
    sumRight = negMod(sumRight % 3);

    int firstZero = a.length, firstOne = a.length, firstTwo = a.length,
            lastZero = -1, lastOne = -1, lastTwo = -1;
    for (int i = 0; i < a.length + 1; i++) {
        if (sumLeft % 3 == 0 && firstZero == a.length)
            firstZero = i;
        if (sumRight % 3 == 0 && lastZero == -1)
            lastZero = a.length - 1 - i;
        if (sumLeft % 3 == 1 && firstOne == a.length)
            firstOne = i;
        if (sumRight % 3 == 1 && lastOne == -1)
            lastOne = a.length - 1 - i;
        if (sumLeft % 3 == 2 && firstTwo == a.length)
            firstTwo = i;
        if (sumRight % 3 == 2 && lastTwo == -1)
            lastTwo = a.length - 1 - i;
        sumLeft += negMod(a[min(i, a.length - 1)] % 3);
        sumRight = negMod(sumRight - a[max(a.length - 1 - i, 0)] % 3);
    }
    int zero = lastZero - firstZero + 1;
    int one = lastOne - firstOne + 1;
    int two = lastTwo - firstTwo + 1;
    Integer[] options = new Integer[]{zero, one, two, 0};
    return Collections.max(Arrays.asList(options));
}