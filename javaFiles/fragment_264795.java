private static int sumFactors(int n)
{
    int sum = 0;
    for (int div=1; div<=n/2; div++)
    {
        if (n%div == 0)
        {
            sum += div;
        }
    }
    return sum;
}