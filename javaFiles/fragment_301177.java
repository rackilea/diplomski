public static int factorial(int n) {
    if (n == 0) { 
        return 1; //not reached
    }
    return n * factorial(n-1); //<-- 8 * factorial(8-1) = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 40320
}