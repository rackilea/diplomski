public static int factorial(int n) {
    if (n == 0) { 
        return 1; //not reached
    }
    return n * factorial(n-1); //<-- 1 * factorial(0) = 1 * 1 = 1
}