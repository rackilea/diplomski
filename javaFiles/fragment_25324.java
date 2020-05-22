import java.util.Scanner;

public class AverageScore {
public static void main(String[] args) {

    int x; // Number of students
    int y; // Number of tests per student
    int Score = 0; //Score of each test for each student
    double Average = 0; //Average score
    double Total = 0; //Total score
    double Input = 0; **//Add this in your variable**
    boolean Valid = false; **//Add this in your variable**

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the number of students: ");
        x = keyboard.nextInt();

        System.out.println("Please enter the amount of test scores per student: ");
        y = keyboard.nextInt();

        for (int z = 0; z < x; z++)
        {
            System.out.println("Student " + (z + 1));
            System.out.println("------------------------");

            for (int g=0; g < y; g++)
            {
                System.out.print("Please enter score " + (g + 1) + ":  ");
                Input = new Scanner(System.in).nextInt();

                //validation of your input from 0 to 100
                if(Input>=0&&Input<=100)
                {
                    Valid = true;
                }

                //enter while loop if not valid
                while(!Valid)
                {
                    System.out.println("");
                    System.out.print("Please enter a valid score " + (g + 1) + ":  ");
                    Input = new Scanner(System.in).nextInt();
                    if(Input>=0&&Input<=100)
                    {
                        Valid = true;
                    }
                }

                Valid = false; //reset validation;

                Total += Input;
                Average = (Total/y);
            }       

            System.out.println("The average score for student " + (z + 1) + " is " + Average);
            System.out.println("                      ");

            Total= 0;
        }

        keyboard.close();
    }
}