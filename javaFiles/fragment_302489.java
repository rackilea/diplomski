class Fibonacci
{
    public static void main (String[] args)
    {
        int fiboFirst = 1;
        int fiboSecond =2;
        int fib = 0;
        int sum = 0;

        while(fiboSecond < 4000000)
          {
            // This will calculate the current term of the sequence
            fib = fiboFirst + fiboSecond;  

            // Below two lines will update fib[i] and fib[i - 1] terms
            // for the next loop iteration.
            fiboFirst = fiboSecond;   // fib[i]
            fiboSecond = fib;   // fib[i -1]
            if (fib % 2 == 0)
              {
                sum = sum + fib;
              }
          }
        System.out.println(sum+2);
    }
}