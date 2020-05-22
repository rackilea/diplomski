public static void main (String args[])
{

    Scanner input = new Scanner(System.in);
    System.out.println("\nLab1a\n");
    final int MAX = 100;
    boolean primes[];
    primes = new boolean[MAX];


    ArrayList<Integer>PrimeFactor = new ArrayList<Integer>();
    for (int i = 1; i < MAX + 1; i++)
    {
       PrimeFactor.add(i);
    }

    CompositeNumbers(PrimeFactor);
    System.out.println("Computing Prime Numbers");
    System.out.println();
    System.out.println("Primes Between 1 and 100");
    System.out.println(PrimeFactor);
}

public static void CompositeNumbers(ArrayList<Integer> PrimeFactor)
{
    for (int i = 0; i < PrimeFactor.size(); i++)
    {
        if (!isPrime(PrimeFactor.get(i)))
        { 
            PrimeFactor.remove(i);
        }
    }
}

public static boolean isPrime(int n)
{
    if(n==1)
    {
        return true;
    }
    for (int i = 2; i < n+1/2; i++)
    {
        if (n%i == 0)
        {
            return false;
        }
    }
    return true;
}