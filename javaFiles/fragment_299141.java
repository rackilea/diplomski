import java.util.Random;
import java.util.Scanner;

public class MathFunction {

    int a, b, c;
    double userAnswer, correctAnswer;
    int numCorrect = 0; 
    Random ranNum = new Random();
    Scanner input = new Scanner(System.in);
    //You function to calculate
    public static compute()
    {
     for (int problem = 1; problem <= 10; problem++)
        {
            a = ranNum.nextInt(2) + 1;
            b = ranNum.nextInt(41) - 20;
            c = ranNum.nextInt(41) - 20;

            System.out.print("\n"+ a + "x + " + b + " = " + c + " ... x = ");

            userAnswer = input.nextDouble();
            correctAnswer = 1.0 * (c - b) / a;

            if (userAnswer == correctAnswer)
            {
                System.out.println("Correct!");
                numCorrect =+ 1;
            }
            else
            {
                System.out.println("Sorry, correct answer is " + correctAnswer);
            }

        }//end for loop
         System.out.println("You got " + numCorrect + " out of ten.");
         System.out.println("\nWant to do 10 more questions? <y/n>");

    }

    public static void main(String[] args) {
        // Then start by sking a question like "Ready to staxt Y/N"

        //get user responce or user input and if user input is Y then call the compute method else  system exit.

        if(userAnswer=="Y")
        {
            compute();
        }
        else{
            //Thanks for participating system closes.
            System.exit(0);
        }



    }//end main
}//end class