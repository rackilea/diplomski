public static int digitPow(int n) {
    int result = 0;
    int count = (int)(Math.log10(n) + 1); // number of digits in n

    while (count > 0) {
        result += Math.pow((n % 10), count);
        n /= 10;
        count--;
    }

    return result;
}