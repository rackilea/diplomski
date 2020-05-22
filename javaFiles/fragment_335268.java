public class TestSum {
   public static void main(String[] args) {
          double result= integrate(0, 1000);
          System.out.print("result = " + result );
   }

   public static double integrate(double start, double end) {
    double currentIntegralValue = 0;
    double dt=0.01d;
    double t = start;

    while (Math.abs(end - t) >= dt && t-end < 0) {
        currentIntegralValue += fn(t)*dt;
        t += dt;
    }
    return currentIntegralValue;
   }

   private static double fn(double t) {
        double sech = 1 / Math.cosh(t);
        double squared = Math.pow(sech, 2);
        return  ((Math.pow(t, 0.5))*squared); 
   }
}