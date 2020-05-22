private static long gcd(long a, long b)
{
    while (b > 0)
    {
        long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

public static long mainNumber()
{
    long number = 1;
    for(int i = 2; i <= 20; i++) {
        number = number * (i / gcd(number, i));
    }
    return number;
}

public static void main(String[] args)
{
    Smallest_multiple result =new Smallest_multiple();
    System.out.println("The Smallest Multiple: " + result.mainNumber());
}