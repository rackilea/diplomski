public Craps() {
    currentNumber = rollDice();
    switch (currentNumber) {
        case 7:case  11:
            gameResult = Outcome.WIN_FIRST;
            break;
        case 2:case 3:case 12:
            gameResult = Outcome.LOSE_FIRST;
            break;
        default:
            point = currentNumber;
    }
}