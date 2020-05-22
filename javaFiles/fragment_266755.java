public static BigInteger karatsuba(BigInteger x, BigInteger y) {

    // cutoff to brute force
    int n = Math.max(x.bitLength(), y.bitLength());
    if (n <= 10) return x.multiply(y);

    // number of bits divided by 2, rounded up
    n = (n / 2) + (n % 2);

    final BigInteger b = x.shiftRight(n);
    final BigInteger a = x.subtract(b.shiftLeft(n));
    final BigInteger d = y.shiftRight(n);
    final BigInteger c = y.subtract(d.shiftLeft(n));

    // compute sub-expressions
    final BigInteger ac = karatsuba(a, c);
    final BigInteger bd = karatsuba(b, d);
    final BigInteger abcd = karatsuba(a.add(b), c.add(d));

    return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(2 * n));
  }