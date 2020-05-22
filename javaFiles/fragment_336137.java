for (int count = 0; count < 20; count++) {

    int rollValue = diceNumber.nextInt(6) + 1;

    if (rollValue == 1) {
        System.out.println("1");
    } else if (rollValue == 2) {
        System.out.println("2");
    } else if (rollValue == 3) {
        System.out.println("3");
    } else if (rollValue == 4) {
        System.out.println("4");
    } else if (rollValue == 5) {
        System.out.println("5");
    } else if (rollValue == 6) {
        System.out.println("6");
    } else {
        // This else is now redundant
        System.out.println(diceNumber);
    }
}