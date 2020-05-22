import java.util.Scanner;
class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a;
        double b;
        System.out.println("Enter a: ");
        a = in.nextDouble();

        System.out.println("Enter b: ");
        b = in.nextDouble();
        double value = a - b;



        //If value is negative...make it a positive number.
        value = (value < 0) ? -value : value;
            System.out.println("|"+a + "-" + b +"|" + " =" + value);  // value should be printed here instead of (a-b) or (b-a)
        System.out.println("|"+b + "-" + a +"|" + " =" + value);

    }
}