public static boolean isPrimeNumber(int i) {
    if (i==2) return true;
    if (i==3) return true;
    if (i%2==0) return false;
    if (i%3==0) return false;

    int j = 5;
    int k = 2;

    while (j * j <= i) {
        if (i % j == 0) return false;
        j += k ;
        k = 6 - k;

    }
    return true;
}