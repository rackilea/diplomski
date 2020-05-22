import java.util.*;

public class DiceRoller
{
    private Random rand;

    public DiceRoller()
    {
        this.rand = new Random();
    }

    public int rollSingleDie()
    {
        return rand.nextInt(6)+1;
    }

    public List<Integer> roll4d6DropLowest()
    {
        List<Integer> retList = new ArrayList<Integer>();

        // Add 4 numbers to the list to simulate 4 rolls.
        for (int i=0; i<4; i++)
        {
            retList.add(rollSingleDie());
        }

        // Remove the lowest roll of the 4. 
        retList.remove(Collections.min(retList));

        return retList;
    }

    public List<List<Integer>> rollSets(int numSets)
    {
        List<List<Integer>> results = new List<List<Integer>>();
        for (int i=0; i<numSets; i++)
        {
            results.add(roll4d6DropLowest());
        }
        return results;
    }
}