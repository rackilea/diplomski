private static Map<Integer, BigInteger> memo = new TreeMap<>();
private static final BigInteger NEGATIVE_ONE = new BigInteger("-1");

public static BigInteger fib(final int n) {
    if (n < 0) {
        // This if block adds the "negafibonacci" support.
        final int p = Math.abs(n);
        final boolean even = p % 2 == 0;
        if (even) {
            return NEGATIVE_ONE.multiply(fib(p));
        }
        return fib(p);
    } else if (n == 0) {
        return BigInteger.ZERO;
    } else if (n == 1 || n == 2) {
        return BigInteger.ONE;
    }
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    BigInteger r = fib(n - 1).add(fib(n - 2));
    memo.put(n, r);
    return r;
}

public static void main(String[] args) {
    for (int i = -8; i <= 8; i++) {
        System.out.println(fib(i).toString());
    }
}