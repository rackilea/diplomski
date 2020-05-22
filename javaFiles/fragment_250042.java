public static int[] diceRolls(Die die, int numberOfRolls) {

    int[] results = new int[numberOfRolls];
    for (int roll = 0; roll < numberOfRolls; roll++) {
        results[roll] = die.roll();
    }

    return results;

}
public static int sumDiceRolls(Die die, int numberOfRolls) {

    int[] results = diceRolls(die, numberOfRolls);
    int sum = 0;
    for (int result : results) {
        sum += result;
    }

    return sum;

}