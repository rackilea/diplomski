public static boolean isDivisibleByAll(int dividend, int fromDivisor, int toDivisor) {
    for (int divisor = fromDivisor; divisor <= toDivisor; divisor++)
        if (dividend % divisor != 0)
            return false;
    return true;
}