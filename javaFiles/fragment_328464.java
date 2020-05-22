private Random rand = new Random();

/**
 * @param roll can be a multipart roll which is run and added up. e.g. d6+2-d4
 */
public int multiPartRoll(String roll) {
    String[] parts = roll.split("(?=[+-])"); //split by +-, keeping them
    int total = 0;
    for (String partOfRoll : parts) { //roll each dice specified
        total += singleRoll(partOfRoll);
    }
    return total;
}

/**
 * @param roll can be fixed value, examples -1, +2, 15 or a dice to roll
 * d6, +d20 -d100
 */
public int singleRoll(String roll) {
    int di = roll.indexOf('d');
    if (di == -1) //case where has no 'd'
        return Integer.parseInt(roll);
    int diceSize = Integer.parseInt(roll.substring(di + 1)); //value of string after 'd'
    int result = rand.nextInt(diceSize) + 1; //roll the dice
    if (roll.startsWith("-")) //negate if nessasary
        result = -result;
    return result;
}