public static BigInteger FibonacciB(int n) {
    final BigInteger one = BigInteger.ONE;
    final BigInteger zero = BigInteger.ZERO;
    final BigInteger two = new BigInteger(String.valueOf(2));
    final BigInteger minusOne = one.negate();

    BigInteger num = new BigInteger(String.valueOf(n));

    if (num.equals(zero)) {
        return zero;
    } else if (num.compareTo(two) <= 0) {
        return one;
    }

    BigInteger[][] number = {{one, one}, {one, zero}};
    BigInteger[][] result = {{one, one}, {one, zero}};

    while (num.compareTo(zero) > 0) {
        if (num.mod(two).equals(one)) result = MultiplyMatrixB(result, number);
        number = MultiplyMatrixB(number, number);
        num = num.divide(two);
    }

    if (num.compareTo(zero) < 0)
        return result[1][1].multiply(minusOne);
    return result[1][1];

}