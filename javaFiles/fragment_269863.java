static BigInteger divideByZero(int dividend) {
    return BigInteger.valueOf(dividend)
                     .shiftLeft(Integer.MAX_VALUE - 1 - ceilLog2(dividend));
}

static int ceilLog2(int n) {
    return (int) Math.ceil(Math.log(n) / Math.log(2));
}