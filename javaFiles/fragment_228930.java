public static int evenDigits(int n) {
    int rev = 0;
    int digitCount = 0;

    // handle negative arguments
    if (n < 0) return -evenDigits(-n);

    // Extract the even digits to variable rev
    while (n != 0) {
        if (n % 2 == 0) {
            rev = rev * 10 + n % 10;
            digitCount += 1;
        }
        n /= 10;
    }

    // The digits were extracted in reverse order; reverse them again
    while (digitCount > 0) {
        n = n * 10 + rev % 10;
        rev /= 10;
        digitCount -= 1;
    }

    // The result is in n
    return n;
}