public long facDigits(long n) {
    double logFacN = 0;
    for (long i = 2; i <= n; i++) {
        logFacN += Math.log10(i);
    }
    return (long) logFacN + 1;
}

public void test() {
    double tenToThe7th = Math.pow(10, 7);
    long digits = facDigits((long) tenToThe7th);
    System.out.println("Digits in " + tenToThe7th + "! = " + digits);
}