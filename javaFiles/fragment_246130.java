class Program
{
    static void Main(string[] args)
    {
        for (var i = 1; i <= 10; i++)
        {
            if (!IsPrime(i)) continue;

            for (var j = 1; j <= 5; j++)
            {
                var value = i * j;
                Console.WriteLine(i + " multiplied by " + j + " = " + value);
            }
        }

        Console.ReadLine();
    }

    public static bool IsPrime(int candidate)
    {
        if ((candidate & 1) == 0)
        {
            return candidate == 2;
        }

        for (var i = 3; (i * i) <= candidate; i += 2)
        {
            if (candidate % i == 0)
            {
                return false;
            }
        }
        return candidate != 1;
    }
}