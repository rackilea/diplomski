public static int factorial(int n) {

    if (n == 0) {
        return 1; 
    }
    else {
        int recurse = factorial(n - 1);
        return recurse * n;
    }
}