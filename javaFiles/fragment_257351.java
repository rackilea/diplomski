public static double pow(double a, int b) {
    double result = 1;
    while(b > 0) {
        if (b % 2 != 0) {
            result *= a;
            b--;
        } 
        a *= a;
        b /= 2;
    }

    return result;

}