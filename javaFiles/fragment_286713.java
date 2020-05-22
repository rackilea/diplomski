public static double power(double x, int n) {
    double s = 1.0d;
    while(n != 0) {
        if((n&0x01) != 0x00) {
            s *= x;
        }
        n >>>= 0x01;
        x *= x;
    }
    return s;
}