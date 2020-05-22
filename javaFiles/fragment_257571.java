do {
    dice1 = randomGeneratorDice1.nextInt(6) + 1;
    dice2 = randomGeneratorDice2.nextInt(6) + 1;
    sumElse = dice1 + dice2;
    if (sumElse == sum) {
        System.out.println("You win!!");
        winNumber++;
        break;
    } // end inner if
    else if (sumElse == 7) {
        System.out.println("You lose!!");
        lossNumber++;
        break;
    } // end inner else

} while (true);