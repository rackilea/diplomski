public static void main(String args[])
{
    /*** Rolling the initial sets ***/
    int numSets = 10; // Ten is a placeholder.
                      // This is where you get input from user.

    DiceRoller roller = new DiceRoller();
    List<List<Integer>> diceSets = roller.rollSets(numSets);

    for (List<Integer> diceRolls : diceSets)
    {
        Integer total = sum(diceRolls);
        Integer lowest = Collections.min(diceRolls);
        System.out.println("Total is : " + total + " and lowest is : " + lowest);
    }

    /*** Forcing user to reroll lowest of one set ***/
    int setToRerollIndex = 1; // Placeholder value.
    // Replace with input from user on which set to reroll.
    // Remember to adjust user input - they will probably use a number between 1 
    // and the number of sets, but the List needs an index between 0 and the number of
    // sets - 1. 
    List<Integer> setToReroll = diceSets.get(setToRerollIndex);
    int indexOfLowest = setToReroll.indexOf(Collections.min(setToReroll));
    setToReroll.set(indexOfLowest, roller.rollSingleDie());

    // Selected set has now rerolled the lowest value.
}

public static int sum(List<Integer> list)
{
    int sum= 0; 
    for (int number : list)
        sum = sum + number;
    return sum;
}