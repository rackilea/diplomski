import java.util.Random;
public class CoinToss{
   public static void main(String[] args)
   {
      Random rand = new Random();
      int numHeads = 0;
      int numTails = 0;

        for (int i = 0; i < 10; i++)
        {
            if (rand.nextInt(2) == 0)
                numTails++;
            else
                numHeads++;
        }
        System.out.println("Heads: " + numHeads);
        System.out.println("Tails: " + numTails);
    }