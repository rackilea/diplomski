public static BigInteger factorialOf(int x) {
    return IntStream.rangeClosed(1, x).mapToObj(BigInteger::valueOf)
        .reduce(BigInteger::multiply).orElse(BigInteger.ONE);
}
public static int sumOf(BigInteger y) {
    return y.toString().chars().map(i -> i-'0').sum();
}