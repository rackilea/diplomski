private static long Raju_Iterative(int n)
{        
    if (n < 0)
        return 0L;
    long a = 1L;
    long b = 1L;
    for(int i = 0; i < n-1; i++) {
        long c = a+b+1;
        a = b;
        b = c;
    }
    return b;
}