import java.util.*;

public class FutureValues {

    public static void main(String[] args) {
        Scanner CONSOLE = new Scanner(System.in);

        System.out.print("present value   : ");
        double Pvalue = CONSOLE.nextDouble();
        System.out.print("interest rate   : ");
        double Interest = CONSOLE.nextDouble();
        System.out.print("number of years : ");
        double Years = CONSOLE.nextDouble();

        double Fvalue1 = method1(Pvalue, Interest, Years);

        System.out.print("The future value using compound interest = " + Fvalue1);
    }

    public static double method1(double Pvalue, double Interest, double Years) {
        return Pvalue * Math.pow(1 + Interest / 100, Years);
    }
}