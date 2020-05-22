import java.util.*;
import java.math.*;

public class Extrema
{
   public static void main(String[] args)
   {
      double step = 0.00001;
      double x = -1.0;
      double xn = 3;
      double highest = calc(x);
      while (x <= xn)
      {
         double f = calc(x);
         if (f > highest)
         {
            highest = f;
         }
         x += step;
      }
     System.out.println(highest);
   }
   public static double calc(double x)
   {
      double f = 2*Math.pow(x, 3) - 8*Math.pow(x, 2) + x + 16;
      return f;
   }
}