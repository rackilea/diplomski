import java.util.Scanner;

public class Foo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        boolean catcher = false;
        do {
            try {
                System.out.print("Enter a number: ");
                a = sc.nextInt();
                catcher = true;
            } catch (Exception e) {
            } finally {
                sc.nextLine();
            }

        }
        // !!while(catcher == false);
        while (!catcher);

        System.out.println("a is: " + a);
    }
}