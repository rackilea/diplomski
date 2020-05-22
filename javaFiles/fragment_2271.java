public static void findPower(double value) {
    if (value < 1 || value % 1 != 0)
        throw new IllegalArgumentException("Invalid input: " + value);
    boolean found = false;
    for (int exp = 2; ; exp++) {
        long base = Math.round(Math.pow(value, 1.0 / exp));
        if (base < 2)
            break;
        if (Math.pow(base, exp) == value) {
            System.out.printf("%.0f = %d ^ %d%n", value, base, exp);
            found = true;
        }
    }
    if (! found)
        System.out.printf("%.0f has no solution%n", value);
}