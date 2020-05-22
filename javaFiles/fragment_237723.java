private static double addInterest(double S, double P, double i)
{
    return S + (P * i);
}

...

public static void main()
{
    ...
    while (timesLooped <= n)
    {
        S = addInterest(S, P, i);
    }