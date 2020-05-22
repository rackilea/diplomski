import java.lang.*;

public class MathDemo {

   public static void main(String[] args) {

  // get two double numbers
  double x = 2.0;
  double y = 5.4;

  // print x raised by y and then y raised by x
  System.out.println("Math.pow(" + x + "," + y + ")=" + Math.pow(x, y));// works like x^y
  System.out.println("Math.pow(" + y + "," + x + ")=" + Math.pow(y, x));//works like y^x

   }
}