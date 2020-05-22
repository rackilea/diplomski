import java.util.Scanner;
public class TestScoreStatistics 
{

    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int testScore;
        double totalScore = 0;
        final int QUIT = 999;
        final String PROMPT = "Enter a test score >>> ";
        int lowScore = 100; //setting the low score to the highest score possible
        int highScore = 0; //setting the high score to the lowest score possible
        String scoreString = "";
        int counter = 0;

        System.out.print(PROMPT);
        testScore = scn.nextInt();

        while (testScore != QUIT)
        {

            if (testScore < 0 || testScore > 100 )
            {
                System.out.println("Incorect input field");

            }
            else
            {
                scoreString += testScore + " ";
                counter++;
                //getting the new lowest score if the testScore is lower than lowScore
                if(testScore < lowScore){
                    lowScore = testScore;
                }
                //getting the new highest score if the testScore is higher than highScore
                if(testScore > highScore){
                    highScore = testScore;
                }
                totalScore += testScore; //adding up all the scores
            }

            System.out.print(PROMPT);
            testScore = scn.nextInt();
         }
        double averageScore = totalScore / counter; //getting the average
     }