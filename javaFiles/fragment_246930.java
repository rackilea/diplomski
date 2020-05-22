//method to return number of occurrences of the numbers in diceRolls
int[] countOccurrences(int[] diceRolls) {
    int occurrence[] = new int[6]; //to hold the counts

    for(int i = 0; i < diceRolls.length; i++) { //Loop over the dice rolls array
       int value = diceRolls[i]; //Get the value of the next roll
       occurence[value]++; //Increment the value in the count array this is equivalent to occurrence[value] = occurrence[value] + 1;
       //occurrence[diceRolls[i]]++; I broke this into two lines for explanation purposes
    }

    return occurrence; //return the counts 
}