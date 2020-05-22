class NumbersEntered {

public double total = 0; //declare as accessable field

public  void operatorSeletion(double number1, double number2, double number3, char operator)
{     
    switch(operator)
    {
        case '+':
            total = number1 + number2 + number3;
            break;

        case '-':
            total = number1 - number2 - number3;
            break;

        case '*':
            total = number1 * number2 * number3;
            break;

        case '/':
            total = number1 / number2 / number3;
            break;

        default:
            System.out.println("You have entered incorrectly. Please try again.");

            return;
    }       
}
}
public class JavaPresentation_KS {


public static void main(String[] args) {

    NumbersEntered nums = new NumbersEntered();
    Scanner equation = new Scanner(System.in);

    System.out.println("Enter first number: ");
    double number1 = equation.nextDouble();
    System.out.println("Enter second number: ");
    double number2 = equation.nextDouble();
    System.out.println("Enter third number: ");
    double number3 = equation.nextDouble();
    System.out.println("Enter an operator (+, -, *, /): ");
    char operator = equation.next().charAt(0);

    nums.operatorSeletion(number1, number2, number3, operator); 
//invoke the method

    System.out.println(number1 + " " + operator + " " + number2 + " " + operator + " " + number2 + " = " + nums.total);
//Access at location (nums.total)   
    }