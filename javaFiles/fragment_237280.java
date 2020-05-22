public static int nthNumber(int nth) {
    int num = 1;
    for (int count = 1; count < nth;) {
        if ((++num % 3 == 0) == (num % 7 == 0)) count++;
    }
    return num;
}