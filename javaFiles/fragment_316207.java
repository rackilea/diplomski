public static double fastTenPow(double x) {
    if (x < 0.) {
        return 1. / fastTenPow(-x);
    }
    int intPart = (int) x;
    double fractPart = x - intPart;
    return fractTenPow(fractPart) * intTenPow(intPart);
}

private static double intTenPow(int x) { // copied it
    double res = 1.;
    double base = 10.;
    while (x != 0) {
        if ((x & 1) == 1) {
            res *= base;
        }
        x >>= 1;
        base *= base;
    }
    return res;
}

private static final double LOG_TEN = 2.3025850929940456840179914546843642076011014886287729;
private static final double EPS = 0.00000000000000001;

private static double fractTenPow(double x) {
    double sum = 0.;
    x *= LOG_TEN;
    double tmp = 1.;
    for (double i = 1.; tmp > EPS; i += 1.) {
        sum += tmp;
        tmp *= x;
        tmp /= i;
    }
    return sum;
}