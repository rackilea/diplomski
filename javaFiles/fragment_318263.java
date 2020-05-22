private static boolean ternary(int a, int b, int c) {
    for (int i = 0; i < 3; i++) {
        if ((a % 3 + b % 3 + c % 3) % 3 != 0) {
            return false;
        }

        a /= 3;
        b /= 3;
        c /= 3;
    }

    return true;
}