import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BasketballTeam
{
    public static void main(String[] args) throws IOException
    {
        File f = new File("BasketballData.txt");

        if (f.exists())
        {
            Scanner input = new Scanner(f);
            int games = 0;
            int totalScore = 0;
            double avg = 0.0;

            while (input.hasNext())
            {
                String s = input.next();
                System.out.printf("%-9s", s);
                while (input.hasNextInt())
                {
                    int a = input.nextInt();
                    if(a != -1)
                    {
                        System.out.printf("%5s", a);
                        games++;
                        totalScore = totalScore + a;
                    }
                }
                avg = (double)totalScore/games;
                System.out.printf("%14s%.2f\n", "Average of ", avg);
                games = 0;
                totalScore = 0;
                System.out.println();
            }
            input.close();
        }
    }
}