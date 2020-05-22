public class Lottery
{
   Random random = new Random();
   int number;
   int count;
   int lotteryNums[];
    public Lottery()
    {
        lotteryNums[] = new int[5]; //Set the variable in the class so we can use it later
        for (int i=0; i < lotteryNums.length; i++)
        {
            number = random.nextInt(10);
            lotteryNums[i] = number;
        }
    }

    public int CompareNums(Picks[] numbers) //Removed static since numbers are made in a constructor. All non-static class variables wouldn't be accessible otherwise.
    {
        for (int i=0; i <Picks.length; i++)
        {
            if (Picks[i] == lotteryNums[i])
            {
                System.out.println("The number on " + (i+1)+ " matches");
                count++;
            }
            else 
            {
               System.out.println("the number on " + (i+1)+ " matches");
            }
       }
        return count;
    }
}