static long Combinatory(long n, long k)
    {
        if (n - k < k)
            k = n - k;

        long res = 1;

        for (int i = 1; i <= k; ++i)
        {
            res = (res * (n - i + 1)) / i;
        }

        return res;
    }