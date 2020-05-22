public static int factorial(int n) {
    if (n == 0) { 
        return 1; //<-- Returns 1
    }
    return n * factorial(n-1);
}