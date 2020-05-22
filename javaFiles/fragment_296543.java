import java.util.Scanner;

public class PROBLEM3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input number of lines:");
        int i = 0, j, k, n;
        n = scan.nextInt();

        for (k = 1; k <= (n + 1) / 2; k++) {
            for (i = 0; i < n - k; i++) {
                System.out.print(" ");
            }
            for (j = 0; j < k; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        for (k = ((n + 1) / 2); k < n; k++) {
            for (i = 1; i < k; i++) {
                System.out.print(" ");
            }
            for (j = 0; j < n - k; j++) {
                System.out.print(" *");
            }
            System.out.println("");
        }

        scan.close();
    }
}