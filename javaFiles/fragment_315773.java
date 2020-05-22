public static int getLargestOddFibonacciBetween(int lo, int hi) {
    assert lo <= hi;

    int f0 = 0;
    int f1 = 1;
    int res = -1;

    while (f1 <= hi) {
        int val = f0 + f1;
        f0 = f1;
        f1 = val;

        if (val >= lo && val <= hi && isOdd(val))
            res = val;
    }

    return res;
}

private static boolean isOdd(int val) {
    return (val & 1) == 1;
}