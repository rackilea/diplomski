import java.io.*;

class game
{
    public static void main (String[]args) throws IOException
    {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);

        String inData;

        System.out.println("Welcome to The Game. Player One, please enter an                                integer higher than 0, and less than 1000...\n");

        inData = stdin.readLine();

        int number = Integer.parseInt(inData);

        if(number >= 1000 || number <= 0)
        {
            System.out.println("Sorry, that number is out of the acceptable     range on numbers...\n");
        }
        else
        {
            System.out.println();
        }

        String f1;

        System.out.println("Player Two, Please enter a guess as to what Player     One's number is...\n");

        f1 = stdin.readLine();
        int guess = Integer.parseInt(f1); 

        while(guess != number)
        {
            if(guess < number)
            {
                System.out.println("Higher. Please Guess Again...\n");
            }
            else if(guess > number)
            {
                System.out.println("Lower. Please Guess Again...\n");
            }

            f1 = stdin.readLine();
            guess = Integer.parseInt(f1); 
        }



    }
}