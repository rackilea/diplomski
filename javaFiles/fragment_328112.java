public static double powerOfTen(int n)
{
 if(n > 0)
  return (10 * powerOfTen(n - 1));

 if(n < 0)
  return (1 / powerOfTen(n - 1));

  return 1;
}