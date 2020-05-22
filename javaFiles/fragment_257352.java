public static double intPow(double base,int pow){
    int c = Integer.numberOfLeadingZeros(pow);

    pow <<= c;

    double value = 1;
    for (; c < 32; c++){
        value *= value;
        if (pow < 0)
            value *= base;
        pow <<= 1;
    }

    return value;
}