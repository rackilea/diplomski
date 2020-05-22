private static boolean isInt1(double x) {
    return x == (int) x;
}

private static boolean isInt2(double x) {
    return x == Math.ceil(x);
}

private static boolean isInt3(double x) {
    return x % 1 == 0;
}