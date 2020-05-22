public static void diceRoll(int dice, int numberOfDice) {
    Deque<Integer> list = new ArrayDeque<>(dice);
    diceRoll(dice, numberOfDice, list); // initially we have chosen nothing
}

// Private recursive helper method to implement diceRoll method.
// Adds a 'list' parameter of a list representing
private static void diceRoll(int dice, int numberOfDice, Deque<Integer> list) {
    if (dice == 0) {
        // Base Case: nothing left to roll. Print all of the outcomes.
        System.out.println(list);
    } else {
        // Recursive case: dice >= 1.
        for (int i = 1; i <= numberOfDice; i++) {
            list.addLast(i); // choose
            diceRoll(dice - 1, numberOfDice, list); // explore
            list.removeLast(); // un-choose
        }
    }
}