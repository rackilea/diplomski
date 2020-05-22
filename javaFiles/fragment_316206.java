double tenPow(double x) {
    // ln(10)
    double logTen = 2.3025850929940456840179914546843642076011014886287729;
    double sum = 0.;
    x *= logTen; // x * ln(10)
    double tmp = 1.;
    for (double i = 1.; tmp > 0.; i += 1.) {
        sum += tmp;
        tmp *= x;
        tmp /= i;
    }
    return sum;
}