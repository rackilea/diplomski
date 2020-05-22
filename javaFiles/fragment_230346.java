double twoPlusSqrt(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        } else if (n == 1) {
            return Math.sqrt(2);
        } else {
            return Math.sqrt(2 + twoPlusSqrt(n - 1));
        }
}