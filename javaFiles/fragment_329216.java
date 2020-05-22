public static int evenDigits(int n) {
    if ((n & 1) != 0) {
        // Last digit is odd, so remove it. Recurse on higher digits
        return evenDigits(n / 10);
    }
    if (n < 10) {
        // Single digit number is even, so we're done
        return n;
    }
    // Keep last digit (it is even). Recurse on higher digits
    return n % 10 + evenDigits(n / 10) * 10;
}