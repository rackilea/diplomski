public static long RussianPeasantMult(long a, long b) {
    long sum = 0;
    while(a != 0) {
        if((a & 1) == 1) {
            sum += b;
        }
        a >>>= 1;
        b <<= 1;
    }
    return sum;
}