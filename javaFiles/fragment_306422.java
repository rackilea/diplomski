import java.util.Scanner;
class Test {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter your double: ");
        double d = sc.nextDouble();

        System.out.print("Enter your integer: ");
        int i = sc.nextInt();

        System.out.println("You entered:  " + d + " and " + i);
    }
}