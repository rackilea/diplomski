static long f(long n)
{
    return f(n, new long[40]);
}

static long f(long n, long[] serie)
{
    // Code as before, but when you recurse, pass in serie as well
}