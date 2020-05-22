public class Assign6
{
    public static void main(String[] args)
    {
        // Scanner to Obtain Input from CW
        Scanner input = new Scanner(System.in);
        // Generate Random Number for Quiz
        Random randomNumbers = new Random();
        int number1 = 0;
        int number2 = 0;
        int answer = 0;
        // Rolls number from 1-9
        number1 = randomNumbers.nextInt(9);
        number2 = randomNumbers.nextInt(9);

        displayQuestion("How much is " + number1 + " times " + number2 + "?");

        answer = input.nextInt();
        // If Else While Statements
        if (answer == (number1 * number2))
        {
            displayMessage(Boolean.TRUE);
        }
        else
        {
            while (answer != (number1 * number2))
            {
                displayMessage(Boolean.FALSE);

                answer = input.nextInt();

            }
        }
    }

    public static void displayQuestion(String q)
    {
        System.out.println(q);
    }

    public static void displayMessage(Boolean isCorrect)
    {
        if (isCorrect)
        {
            System.out.println("Good job! You got it right!");
        }
        else
        {
            System.out.println("You got it wrong, try again!");
        }
    }

}