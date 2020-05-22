private static Map<Integer, BigInteger> fibCache = 
    new HashMap<Integer, BigInteger>();

public static BigInteger fib(int n) {
    // Uses the following identities, fib(0) = 0, fib(1) = 1 and fib(2) = 1
    // All other values are calculated through recursion.
    if (n > 0) {
        // fib(1) and fib(2)
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        synchronized (fibCache) {
            if (fibCache.containsKey(n)) {
                return fibCache.get(n);
            }
            BigInteger ret = fib(n - 2).add(fib(n - 1));
            fibCache.put(n, ret);
            return ret;
        }
    } else if (n == 0) {
        // fib(0)
        return BigInteger.ZERO;
    }
    if (n % 2 == 0) {
        return fib(-n).multiply(BigInteger.ZERO.subtract(BigInteger.ONE));
    }
    return fib(-n);
}

public static void main(String[] args) throws Exception {
    for (int x = -8; x <= 8; x++) {
        System.out.println(fib(x));
    }
}