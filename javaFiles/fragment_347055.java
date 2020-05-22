/**
 * Twiddles one digit.
 */
private static int twiddleDigit(int n) {
    return (n & 1) == 1 ? n - 1 : n + 1;
}

/**
 * Adds one to digits that are even, subtracts one from digits that are odd.
 */
public static int twiddleDigits(int n) {
    if (n < 10) return twiddleDigit(n);
    return twiddleDigits(n / 10) * 10 + twiddleDigit(n % 10);
}