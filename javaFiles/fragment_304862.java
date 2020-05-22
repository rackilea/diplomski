public static BitSet primeSieve(int n)
{
    BitSet isPrime = new BitSet(n+1);

    for (int i = 2; i <= n; i++)
        isPrime.set(i);

    for (int i = 2; i*i <= n; i++)
        if (isPrime.get(i))
            for (int j = i; i*j <= n; j++)
                isPrime.set(i * j, false);

    return isPrime;
}