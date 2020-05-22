public static BigInteger fact(BigInteger n) {
    if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
        return BigInteger.ONE;
    else
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
}