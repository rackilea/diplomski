public class rtd
{
    public static int[] rollthedice(int numSides, int numRolls)
    {
        // An array of total number of rolls (NOT sides) to save the result of all rolls
        int[] rollCounter = new int[numRolls];

        // Let's roll n-th times where n is numRolls
        for (int counter = 0; counter < numRolls; counter++)
        {
            // Let's get a random number between 1 to numSides (A die usually has 6 sides with 1 to 6 dots)
            int randomSide = getRand(1, numSides);

            // Let's store the current roll result in array
            rollCounter[counter] = randomSide;
        }

        return rollCounter;
    }

    /**
     * This method returns a number between a given range inclusive
     */ 
    public static int getRand(int min, int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}