private static BigInteger fasterSum(BigInteger n, BigInteger c) {
    assert c.compareTo(n) < 0;
    BigInteger sum = ZERO, p = ONE;

    for (BigInteger x = ONE; x.compareTo(c) < 0; x = x.add(ONE)) {
        p = p.multiply(x);
        sum = sum.add(p);
    }

    // sum[c,n) x!/(x-c)! = n!/(n-c-1)!/(c+1)
    p = ONE;
    for (BigInteger x = n.subtract(c); x.compareTo(n) <= 0; x = x.add(ONE)) {
        p = p.multiply(x);
    }
    sum = sum.add(p.divide(c.add(ONE)));

    return sum;
}