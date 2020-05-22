public static String toBase12(int n) {
    if (n < 10)
        return Integer.toString(n); // or  String.valueOf(n)  or  "" + n
    if (n == 10)
        return "A";
    if (n == 11)
        return "B";
    return toBase12(n / 12) + toBase12(n % 12);
}