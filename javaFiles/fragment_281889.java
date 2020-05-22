public class FibonacciRunner
{
    public static void main(String[] args)
    {
        for(int i = 0; i <= 12; i++)
        {
            System.out.println(Fibonacci.fib(i));
        }
        for(int i = 0; i <= 12; i++)
        {
            System.out.println(Fibonacci.fibList(i));
        }
    }
}