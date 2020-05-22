private static void factorial(long n) {
    long x = n;
    BigInteger fact = BigInteger.ONE;
    if ((n == 0) || (n == 1)) {
        System.out.println("Factorial is 1");
    } else {
        fact = BigInteger.valueOf(n);
        while (n > 1) {
            fact = fact.multiply(BigInteger.valueOf(n - 1));
            n--;
        }
        System.out.println("Factorial of " + x + " is " + fact);
    }
}