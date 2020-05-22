public static double getCos(double x) {
    double Cos = 0;
    for (int i = 0; i <= 5; i++) {
        Cos += (power(-1, i) * power(x, 2*i)) / factorial(2*i) ;
    }
    return Cos;
}