double ex_taylor_series(double x, int n)
{
     double value;

     for(int i = 0; i < n; i++)
     {
         value += Math.pow(x, i)/(factorial(i));
     }

     return value;
}

private int factorial (int num)
{
      int value = 1;

      for(int i = num; i > 1; i--)
      {
           value *= i;
      }

      return value;
}