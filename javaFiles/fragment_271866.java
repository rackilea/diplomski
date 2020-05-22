private static BigInteger sumOfDigits(BigInteger n) {
    BigInteger sum = BigInteger.ZERO;
    while (n.compareTo(BigInteger.ZERO) == 1) {
        sum = sum.add(n.remainder(ten));
        n = n.divide(ten);
    }
    return sum;
}