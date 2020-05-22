public class Player
{
    public String name;
    public int age;
    public int score;

    public String toString()
    {
        return String.format("\nName : %s\nAge: %d\nScore: %s\n", name, age, score);
    }
}

public static String printPlayerScore(Player[] players) 
{
   String displayResult = "";

   for(Player player : players)
   {
        displayResult += player.toString();
   }

   return displayResult;
}