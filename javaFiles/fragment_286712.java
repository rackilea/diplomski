public static double power(double x, int n) {   
    if(n == 0) {
        return 1;
    }
    double xb = x*x;
    if((n&0x01) == 0x00) {
        return power(xb,n>>>0x01);
    } else {
        return x*power(xb,n>>>0x01);
    }
}