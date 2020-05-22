import java.util.Scanner;

public class GeometricMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter how many numbers you want to process");
        int n = sc.nextInt();

        double product = 1.0;
        for (i = 1; i <= n; i++) {
            System.out.println("Please enter a value");
            product *= sc.nextDouble();
        }
        System.out.println("The product is" + product);
    }
}