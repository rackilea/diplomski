public static double pow(int a, int n) {
    if (n == 0) {
        return 1.0;
    }
    if (n < 0) {
        // Negative power.
        if (a == 0) {
            throw new IllegalArgumentException(
                    "It's impossible to raise 0 to the power of a negative number");
        }
        return 1 / pow(a, -n);
    } else {
        // Positive power

        double powerOfHalfN = pow(a, n / 2);
        if (n % 2 == 1) {
            // Odd n
            return a * powerOfHalfN * powerOfHalfN;
        } else {
            // Even n
            return powerOfHalfN * powerOfHalfN;
        }
    }
}