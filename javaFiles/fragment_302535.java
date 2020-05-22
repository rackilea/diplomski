public static long fib2(int n) {
    long a = 0;
    long b = 1;
    for (int i = 1; i < n; i+=2) {  // note: loop counter of type long
        long c = a + b;
        long d = b + c;
        a = c;
        b = d;
    }
    return (n & 1) == 0 ? a : b;
}