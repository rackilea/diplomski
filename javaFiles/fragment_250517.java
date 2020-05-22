public static double invSqrt(double x) {
    double xhalf = 0.5d * x;
    long i = Double.doubleToLongBits(x);
    i = 0x5fe6ec85e7de30daL - (i >> 1);
    x = Double.longBitsToDouble(i);
    x *= (1.5d - xhalf * x * x);
    return x;
}