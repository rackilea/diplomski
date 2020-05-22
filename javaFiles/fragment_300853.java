public static TailCall<Integer> factorial(int fact, int n) {
    if (n == 1) {
        return TailCalls.done(fact);
    }

    return () -> factorial(fact * n, n-1);
}