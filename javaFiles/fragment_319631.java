public static boolean SameDigits(int num) {
    if (num < 0) return false; // or something else?

    int onesDigit = num % 10;
    num /= 10;
    while (num > 0) {
        if (onesDigit != num % 10) return false; // fail if digits differ
        num /= 10;
    }
    return true;
}