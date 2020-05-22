import java.util.Scanner;

public class New
{

public static void main(String[] args)
{
    System.out.println("Calculator");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Parameter ");
    System.out.print("a      : ");
    float a = scanner.nextFloat();

    System.out.print("+|-|*|/: ");
    String op = scanner.next();

    System.out.print("b      : ");
    float b = scanner.nextFloat();
    float c = 0;

    switch (op)
    {
        case "+":
            c = a + b;
            break;

        case "-":
            c = a - b;
            break;

        case "*":
            c = a * b;
            break;

        case "/":
            c = a / b;
            break;

        default:
            System.out.println("Illegal operant");
    }

    System.out.println("Result: " + c);
}
}