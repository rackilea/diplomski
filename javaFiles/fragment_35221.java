public class Horner
{
   public static final NumberFormat DEFAULT_FORMAT = new DecimalFormat("0.000");

   public static void main(String[] args)
   {
      double [] a = { 8.414, 0.0275, 0.0004, -1.0e-5, 8.0e-8, -2.0e-10, 1.0e-13 };
      for (double x = 0.0; x < 1.0;  x += 0.05)
      {
         double y = a[0] + x*(a[1] + x*(a[2] + x*(a[3] + x*(a[4] + x*(a[5])))));
         System.out.println("x = " + DEFAULT_FORMAT.format(x) + " y = " + DEFAULT_FORMAT.format(y));
      }
   }
}