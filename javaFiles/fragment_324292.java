/*
 * Runs perfectly fine forever 
 * (use ctrl + c to escape execution in terminal, if on Linux)
 */
public class IterationTest
{
    public static void printMe()
    {
        while(true)
        {
            System.out.println("iteration");
        }
    }
    public static void main(String[] args)
    {
        printMe();
    }
}

/*
 * Guaranteed StackOverflow error using infinite recursion
 */
 public class RecursionTest
{
    public static void printMe()
    {
        System.out.println("iteration");
        printMe();
    }

    public static void main(String[] args)
    {
        printMe();
    }
}