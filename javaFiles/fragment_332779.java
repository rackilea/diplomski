import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p, p0, tol;
        int i=1;
        int no;

        System.out.println("Enter approximate p: ");
        p0 = scanner.nextDouble();

        System.out.println("Desired Tolerance: ");
        tol = scanner.nextDouble();

        System.out.println("Maximum Iterations: ");
        no = scanner.nextInt();

        while (i<=no){
            p = g(p0);

            if(Math.abs(p-p0) < tol)
                break;

            System.out.printf("Iteration %d: Current value %f\n", i, p);

            i++;
            p0 = p;

            if(i>no)
                System.out.printf("Method failed after %d iterations\n", no);
        }
    }
    static double g(double x){
        return Math.pow(3*x*x+3, .25);
    }
    static double f(double x){
        return x*x*x*x-3*x*x-3;
    }
}