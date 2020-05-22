public static int countSetBits(long number) {
    int count = 0;
    while (number > 0) {
        count += number&1L;
        number>>=1L;
    }
    return count;
}