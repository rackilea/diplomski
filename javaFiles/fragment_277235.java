import java.io.*;
import java.util.Scanner;

public class Vjezba1
{
public static void main(String[] args)
{
Scanner input=new Scanner(System.in);
Scanner text=new Scanner(System.in);

String opr;
int x;
int y;
int sum;

System.out.println("This is a simple calculator program.");
System.out.println("Input first number: ");
x = input.nextInt();

System.out.println("Input second number: ");
y = input.nextInt();

System.out.println("Choose an operation (+,-,*,/): ");
opr = text.nextLine();
System.out.print(opr);
if(opr.equals("+")){
    sum = x + y;
    System.out.println("Result is: " + sum);
}else if(opr.equals("-")){
    sum = x - y;
    System.out.println("Result is: " + sum);
}else if(opr.equals("*")){
    sum = x * y;
    System.out.println("Result is: " + sum);
}else if(opr.equals("/")){
    sum = x / y;
    System.out.println("Result is: " + sum);
}

}
}