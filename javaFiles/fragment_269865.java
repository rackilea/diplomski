static double goldschmidt(double dividend, 0) {
    while (!Double.isInfinite(dividend)) {
        dividend *= 2.0;
    }
    return dividend;
}