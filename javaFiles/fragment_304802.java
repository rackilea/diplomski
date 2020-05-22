import acm.program.*;

public class App extends ConsoleProgram 
{

        int n = 0;
        int counter = 0;
        int score = 0;


    public void init()
    {
        setSize(300,600);
    }
    public void run()
    {
        //  reset counter variables
        n = 0;
        counter = 0;
        score = 0;

        n = readInt("How many times did you take this quiz: ");

        /*
         * Printing questions
         */

        //  First Question
        Questions questionOne = new Questions();
        println(" ");
        questionOne.SetQuestion("Question 1: ");
        questionOne.SetChoice1("Answer a: ");
        questionOne.SetChoice2("Answer b: ");
        questionOne.SetChoice3("Answer c: ");
        questionOne.SetChoice4("Answer d: ");
        questionOne.SetCorrectAnswer("b");

        //  Second Question
        Questions questionTwo = new Questions();
        println(" ");
        questionTwo.SetQuestion("Question 2: ");
        questionTwo.SetChoice1("Answer a: ");
        questionTwo.SetChoice2("Answer b: ");
        questionTwo.SetChoice3("Answer c: ");
        questionTwo.SetChoice4("Answer d: ");
        questionTwo.SetCorrectAnswer("d");

        //  Third Question (Hard Question)
        Questions questionThree = new Questions();
        println(" ");
        questionThree.SetQuestion("Question 3:  ");
        questionThree.SetChoice1("Answer a: ");
        questionThree.SetChoice2("Answer b: ");
        questionThree.SetChoice3("Answer c: ");
        questionThree.SetChoice4("Answer d: ");
        questionThree.SetCorrectAnswer("a");

        evaluate(new Questions[]{questionOne,questionTwo,questionThree});

    } // closing public run

private void evaluate(Questions[] q){
 //  METHOD FOR DO-WHILE LOOP. 
        do
        {
            if ( n <= 3 )
            {
                println("You may now take the quiz!");
                println(" ");
            } 
            else 
            {
                println("You're out of quiz attempts. You have already taken it 3 times.");
                break;
            }

            do 
            {
            score = 0;

            if (counter==5)
            {
            println("You scored less than 100%");
            println("Take a break! You may retake the quiz on a later date. ");
            break;
            }

            // print question 1
            println(q[0].PrintQuestion());

            // input answer for question number 1
            String yourAnswer = readLine("Your answer: ");
            println(" ");

            // check if the question 1 is correct, if it is, add 1 to the score++
            if (q[0].IsAnswerCorrect(yourAnswer))
            {
                score++;
                println("You got it right!");   
            }
            else    // if its not correct, print you got it wrong
            {
                println("You got it wrong!");
                println(" ");
                println(" ");
            }

            // print question 2
            println(q[1].PrintQuestion());

            // input answer for question number 2
            String yourAnswer2 = readLine("Your answer: ");
            println(" ");

            // check if the question 2 is correct, if it is, add 1 to the score++
            if (q[1].IsAnswerCorrect(yourAnswer2))
            {
                score++;
                println("You got it right!");
            }
            else    // if its not correct, print you got it wrong
            {
                println("You got it wrong!");
                println(" ");
                println(" ");
            }

            // print question 3
            println(q[2].PrintQuestion());

            // input answer for question number 3
            String yourAnswer3 = readLine("Your answer: ");
            println(" ");

            // checking for hard question. To make it easier, we're using boolean to check for the hard question
            boolean hardQuestion = false;

            // check if the question 3 is correct, if it is, add 1 to the score++ // hard question becomes true
            if (q[2].IsAnswerCorrect(yourAnswer3))
             {
                score++; 
                println("You got it right!");
                println(" ");
                hardQuestion = true;
             }
             else
             {
                println("You got it wrong!");
                println(" ");
                println(" ");
             }
             if (score == 0)
             {
                 println("You need more practice!");
                 println(" ");
             }

             // if you got at least the hard one right, your score is of 1 and that is what gets printed out
             else if (score == 1)
             {
                 if (hardQuestion) 
                 {
                     println("Well, at least you got the hard one correct! ");
                     println(" ");
                 }
                 else
                 { 
                     // if the other ones are correct, print out this message if hard is wrong
                     println("You need to warm up!");
                     println(" ");
                 }
             }

             // if you got at least two correct
             else if (score == 2)
             {
                 if (hardQuestion) 
                 {
                     // user got one correct and hard one correct
                     println("You are amazing!");
                     println(" ");
                 }
                 else
                 { 
                     // if hard one was wrong
                     println("You're on your way!");
                     println(" ");
                 }
             }
             else
             {
                 // all answers are correct including the hard ones
                 println("You are a scholar!");
                 println(" ");
                 println("Congradulations you passed! You got 100% on the quiz!");
                 break;
             }
                // count number of tries the quiz has been looped
                counter++;  
                if (counter < 5)
                {
                    println("You scored less than 100%");
                    println(" ");
                    println(" ");
                    println("Try again!");
                    println(" ");
                }
            } while (true); // end program loop

            break;

        } while (true); // end while loop
}

} // closing public class