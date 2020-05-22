package calculator;

 import java.util.Scanner;

    public class Calculator {

    public static void main(String[] args) {

        System.out.println("Hello, welcome to my calculator");
        System.out.println("Enter in some stuff you want to me to calculate");

        Scanner scan = new Scanner(System.in);
        System.out.println("If you need help please type \"help\"");
        System.out.println("If at anytime you want to leave, type \"quit\"");
        System.out.println("If you want to continue, hit enter.");

        String s1 = scan.nextLine();

        if (s1.equals("help")){
            System.out.println(" ");
            System.out.println("Double operand commands:");
            System.out.println("Addition: '+' (Ex: 'a + b' )");
            System.out.println("Subtraction: '-' (Ex: 'a - b' )");
            System.out.println("Multiplication: '*' (Ex: 'a * b' ) ");
            System.out.println("Division: '/' (Ex: 'a / b' )");
            System.out.println("Exponents: '^' (Ex: 'a ^ b' )");
            System.out.println(" ");
        }

        Scanner input = new Scanner(System.in);

        Maths maths = new Maths();

        double answer = 0;
        double numA, numB;
        char operator;
        boolean quit = false;


         while (true) {
            System.out.print("Please enter your equation: ");
            String s=input.next();
            if(s.equals("quit")){
                System.out.println("Thanks for using my programe");
                System.exit(0);
            }
            numA = Double.parseDouble(s);
            operator = input.next().charAt(0);
            numB = input.nextDouble();        

            if (operator == '+') {
                answer = maths.add(numA, numB);
            }

            if (operator == '-') {
                answer = maths.subtract(numA, numB);
            }

            if (operator == '*') {
                answer = maths.multiply(numA, numB);
            }

            if (operator == '/') {
                answer = maths.divide(numA, numB);
            }

            if (operator == '^') {
                answer = maths.power(numA, numB);
            }

            System.out.println(answer);        



         }

        }

    }

    class Maths {

        double add(double a, double b) {
            double answer = a+b;
            return answer;          
        }

        double subtract(double a, double b) {
            double answer = a-b;
            return answer;          
        }

        double multiply(double a, double b) {
            double answer = a*b;
            return answer;          
        }

        double divide(double a, double b) {
            double answer = a/b;
            return answer;          
        }

        double power(double a, double b){
            double answer =a;

            for (int x=2; x<=b; x++){
                answer *= a;
            }

            return answer;
        }
}