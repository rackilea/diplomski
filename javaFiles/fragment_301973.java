import java.util.Scanner;

public class Calculator {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input a");
        double a = input.nextDouble();

        System.out.println("Input b");
        double b = input.nextDouble();

        System.out.println("Input c");
        double c = input.nextDouble();

        double square1 = Math.pow(b, 2);
        double square2 = -4 * a * c;
        double square3 = square1 + square2;

        if (square3 < 0) {
            double square = Math.sqrt(square3);

            double bottom = 2 * a;
            double top1 = -b + square;
            double x1 = top1 / bottom;
            double top2 = -b - square;
            double x2 = top2 / bottom;

            System.out.printf("X = %s", x1);
            System.out.println();
            System.out.printf("X = %s", x2);
        } else {
            System.out
                    .println("Can not calculate square root for negative number");
        }

        input.close();

    }
}