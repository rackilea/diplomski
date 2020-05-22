//This program performs basic math operations such as :- +,-,*,/
public class Calculator {

    double number1, number2;
    String Mathoperation;

    Calculator()

    {

        //you need to remove input and calculation logic from constructor,
        //to avoid running it when constructing this object for testing.
    }

    public void run() {

        getInput();
        double result = doMath(Mathoperation, number1, number2 );

        System.out.println("Your answer is " + result );
    }

    private void getInput() {

        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Enter first number");
        number1 = scannerObject. nextDouble();

        System.out.println("Enter second number");
        number2 = scannerObject. nextDouble();

        Scanner UserInput = new Scanner(System.in);
        System.out.println("\nHere are your options:");
        System.out.println("\n1. Addition, 2. Subtraction, 3. Divison, 4. Multiplication");
        Mathoperation = UserInput.next();
    }

    /**
     *@param mathoperation
     */
    public double  doMath(String mathoperation, double number1, double number2) {

        switch (mathoperation)
        {
        case "1":
            return (number1 + number2);

        case "2":
            return  (number1 - number2);

        case "3":
            return (number1 / number2);

        case "4":
            return (number1 * number2);

        default:
            throw new IllegalStateException("mathoperation is not valid");
        }
    }

    public static void main(String[] args)

    {
        Calculator calc = new  Calculator();
        calc.run();
    }
}