public static int computeGcd(int a, int b) {
    if (a == b) {
        return a;
    }
    for (int i = (int) Math.sqrt(Math.min(a, b)); i >= 2; i--) {
        if (a % i == 0 && b % i == 0) {
            return i;
        }
    }
    return 1;
}