static class GCDHelper
{
    public static long GCD(long a, long b)
    {
        while(b != 0)
        {
            var temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

class Fraction
{
    public long Numerator;
    public long Denominator;

    public Fraction(long numerator, long denominator)
    {
        this.Numerator = numerator;
        this.Denominator = denominator;
    }

    public void Reduce()
    {
        var gcd = GCDHelper.GCD(Numerator, Denominator);
        Numerator /= gcd;
        Denominator /= gcd;
    }

    public double ToNumber() { return (double)Numerator / Denominator; }
}

class Program
{
    static void MultiplyBinomialCoefficient(int n, int k, bool inverse, Fraction f)
    {
        if (k > n / 2)
            k = n - k;
        for(int i = 1; i <= k; ++i)
        {
            if (!inverse)
            {
                f.Numerator *= n - i + 1;
                f.Denominator *= i;
            }
            else
            {
                f.Denominator *= n - i + 1;
                f.Numerator *= i;
            }
            f.Reduce();
        }
    }

    static double Hypergeometric(int K, int k, int N, int m)
    {
        var f = new Fraction(1, 1);
        MultiplyBinomialCoefficient(K, k, false, f);
        MultiplyBinomialCoefficient(N - K, m - k, false, f);
        MultiplyBinomialCoefficient(N, m, true, f);
        return f.ToNumber();
    }

    static void Main(string[] args)
    {
        Console.WriteLine(Hypergeometric(20, 2, 50, 5));
    }
}