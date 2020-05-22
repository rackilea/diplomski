public static long[] firstGap(int gap, long lLimit, long uLimit) {
    for(long i=lLimit; i<=uLimit; i++) {
        if(isPrime(i)) {
            long j = gap + i;
            if (isPrime(j) && !repeatedIsPrime(i + 1, j - 1)) {
                return new long[]{i, j};
            }
        }
    }
    return null;
}