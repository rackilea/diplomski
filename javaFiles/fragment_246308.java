BigInteger getSum(BigInteger n, BigInteger c) {
    BigInteger p = BigInteger.ONE, sum = BigInteger.ZERO;

    for (BigInteger x = BigInteger.ONE; x.compareTo(n) < 0; x = x.add(BigInteger.ONE)) {
        p = p.multiply(x);
        if (x.compareTo(c) > 0) {
            p = p.divide(x.subtract(c));
        }
        sum = sum.add(p);
    }

    return sum;
}