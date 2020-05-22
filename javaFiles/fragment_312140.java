public static double doubleIntMonteCarlo(double a, double b, double c, double d, int n)
{
     double sum = 0D, xSum = 0D, ySum = 0D;

     for (int i = 0; i < n; i++)
     {
           xSum = a + Math.random() * Math.abs(b - a);
           ySum = c + Math.random() * Math.abs(d - c);
           sum += f(xSum, ySum);
     }
     return Math.abs(b - a) * Math.abs(d - c) * sum / n;
}