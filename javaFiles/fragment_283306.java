static long Combinatory(long n, long k)
    {
        if (k == 0 || n == k )
            return 1;

        return Combinatory(n - 1, k) + Combinatory(n - 1, k - 1); 
    }