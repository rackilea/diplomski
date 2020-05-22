// Using Arrays with result as long
private static long sumProduct(int... input) {
    return Arrays.stream(input)
                 .asLongStream()
                 .reduce((a, b) -> a + (1 + a) * b)
                 .getAsLong();
}