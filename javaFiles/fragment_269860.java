static double goldschmidt(double dividend, double divisor) {
    double epsilon = 0.0000001;
    while (Math.abs(1.0 - divisor) > epsilon) {
        double f = 2.0 - divisor;
        dividend *= f;
        divisor *= f;
    }
    return dividend;
}