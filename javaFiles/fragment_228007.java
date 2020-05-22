import java.util.Scanner;

public class Report
{
    public static void main(String[] args)
    {
        String name;

        String[] game = new String[100];
        int[] score = new int[100];
        int[] min = new int[100];

        int nextLine = 0;

        System.out.println("Can you enter your name, game, achievement score, and time played in the following format as shown below:");
        System.out.println("<NAME>");
        System.out.println("<GAME> : <SCORE> : <TIMEPLAYED>");
        System.out.println("Once you have finished your input please notify the program you have finished with the command 'quit':");

        Scanner keyboard = new Scanner(System.in); // initialise Scanner
        name = keyboard.nextLine(); // assign next line of input to name

        for (int index = 0; index < 100; index++)
        {
            String input = keyboard.nextLine(); // next line of input

            if (input.compareToIgnoreCase("quit") == 0)
            {
                break;
            }
            nextLine = nextLine + 1;

            String[] variables = input.split(":"); // perform split
            if (variables.length != 3)
            {
                // handle invalid input here
            }
            game[index] = variables[0].trim(); // first token trimmed of whitespaces
            try
            {
                score[index] = Integer.parseInt(variables[1].trim()); // parse second token as int
                min[index] = Integer.parseInt(variables[2].trim()); // parse third token as int
            }
            catch (NumberFormatException e)
            {
                // handle invalid input here
            }
        }

        for (int index = 0; index < nextLine; index++)
        {

            System.out.println("Players name: " + name);
            System.out.println("-------------------------------");
            System.out.println("Total games: " + game[index]);
            System.out.println("Overall score: " + score[index]);
            System.out.println("Total minutes played: " + min[index]);

            System.out.println(game[index]);
        }
    }
}