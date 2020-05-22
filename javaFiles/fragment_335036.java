import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int height;
        String A = "AA";
        String B = "BB";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your height: ");
        height = sc.nextInt();


        for (int i=1; i<=height; i++){
            for (int j=1; j<=i; j++) {
                if ((j%2) == 1) {
                    System.out.print((i%2 == 1) ? A: B);
                } else {
                    System.out.print((i%2 == 1) ? B :A);
                }
            }
            System.out.println();
        }

    }
}