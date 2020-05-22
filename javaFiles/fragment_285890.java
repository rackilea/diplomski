public class Sine {
   public static void main(String[] args) {

      // This code solves sine according yo the general expansion of sine
      // sin x = x - x³/3! +x^5/5! - x^7/7! +...

      for (double degrees = 0; degrees < 700; degrees += 17) {
         double simplified_degrees = simplify(degrees);
         System.out.println("simplified_degrees = " + simplified_degrees);
         double radians = converttoradian(simplified_degrees);
         System.out.println("radians = " + radians);

         double sin = continued(radians);
         System.out.println(sin);
         System.out.println(Math.sin(radians));
         System.out.println("------------------------------------------");
      }
   }
   // This Makes all the angles that are more than 360
   // To become less than 360 and Generates the simplified
   // Angles for obtuse and reflex angles
   static double simplify(double x) {

      x = x % 360;

      return x;
   }
   // Simple enough and explains itself
   // Converts the angles to radian

   static double converttoradian(double d) {
      return Math.PI / 180. * d;
   }
   // This Method about to open generates each term and adds them together
   // The number of terms solved in this case is 33
   static double continued(double d) {
      double result = 0;
      double sign = 1;
      double dSquared = d * d;

      int pow = 1;
      for (int pow = 1;  pow < 21; pow += 2) {

         long fact = factorial(pow);
         System.out.println("d = " + d + ", fact = " + fact + ", pow = " + pow
               + ", sign = " + sign);
         result = result + (d / fact) * sign;

         d *= dSquared; // effective powers 3, 5, 7,9
         sign = -sign; // alternate sign for every other term

      }
      return result;
   }
   // Evaluates factorials
   static long factorial(int n) {
      if (n == 0 || n == 1) {
           return 1;
      }
      long fact = 1;
      for (long i = 2; i <= n; i++) {
          fact *= i;
      }
      return fact;
    }
}