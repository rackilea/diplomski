public static void main (String[] args)
{
    ArrayList<Integer> A = new ArrayList<Integer>();

    listPrime(A);  
    for(int b = 0; b < A.size(); b++)  // use size and < not <=
    {
        System.out.println(A.get(b)); // use get and round brackets
    }
}
public static boolean isPrime(int number)
{
    for(int f = 2; f <= (number/2) + 1; f++)
    {
        if(number % f == 0)
        {
            return true;
        }
    }
    return false;
}
public static void listPrime(ArrayList<Integer> A)  // return void
{
    for(int i = 1; i <= 100000; i++)
    {
        if(isPrime(i)==false)
        {
            A.add(i);
            //return;  // keep going
        }
    }
    return;  // not really needed
   }