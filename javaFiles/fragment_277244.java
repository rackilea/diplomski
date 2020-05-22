public static int countCommonDigits(int a, int b) {
    int count = 0;
    while (a > 0 && b >0) {
        // Get the right most digits of each number
        int digitA = a % 10;
        int digitB = b % 10;

        // compare them
        if (digitA == digitB) {
            ++count;
        }

        // move on to the next digit
        a /= 10;
        b /= 10;
    }
    return count;
}