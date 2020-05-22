import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decNumber = in.nextInt();

        for (int i = decNumber; i > 0; i = i / 2) {
            int rem = (i % 2);
            System.out.println(rem);
        }

        in.close();
    }
}