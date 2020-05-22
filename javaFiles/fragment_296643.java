package psychic;

import java.util.*;

public class PsychicGameMore
{
    private ArrayList<Player> players;
    private int orginalNumber;

    public static void main(String[] args)
    {
        PsychicGameMore game = new PsychicGameMore();
        game.play();
    }

    public PsychicGameMore()
    {
        int n;
        Scanner s;
        s = new Scanner(System.in);
        System.out.println("How many players will there be?, Please enter a number");
        n = s.nextInt();
        players = new ArrayList<Player>(n);

        //for loop to create n number of Players
        for (int i = 0; i < n; i++)
        {
            Player p;
            p = new Player();


            players.add(p);
        }

        orginalNumber = 0;
    }

    public void play()
    {
        Random myRandom;
        myRandom = new Random();

        boolean hasWon = false;
        do
        {
            orginalNumber = myRandom.nextInt(6) + 1;
            System.out.println("The computer has choosen the number " + orginalNumber);
            for (Player player : players)
            {
                player.play();

                if (orginalNumber == player.getGuessedNumber())
                {
                    System.out.println(player.getName() + " has won!!!!!!!!!!!!!!!!");
                    hasWon = true;
                }

            }
        } while (!hasWon);
    }
}