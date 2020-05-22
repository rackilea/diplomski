boolean b = false;
while (!b) {
    DeckOfCards myDeckOfCards = new DeckOfCards();
    myDeckOfCards.shuffle(); // place Cards in random order

    // print the hand dealt
    for (int i = 0; i < 5; i++) {
        // deal and display a Card
        // System.out.printf("%-19s%n", myDeckOfCards.dealCard());
        hand[i] = myDeckOfCards.dealCard();

        if (i % 5 == 0) { // output a newline after every fifth card,
                            // incase dealing 2 hands in the future
            System.out.println();
        }
    } // end of for loop
    for (int i = 0; i < hand.length; i++) {
        System.out.println("" + hand[i]);
    }
    DeckOfCards.Pair();// check hand for pair, 2 pair, 3 of a kind, four
                        // of a kind, or a full house
    DeckOfCards.hasFlush(hand);// check hand for flush

    System.out.println("\n\n\t" + DeckOfCards.Results() + "\n\n " + DeckOfCards.str);
    b = DeckOfCards.hasStraight(hand);
    System.out.println("Straight= " + b);
    DeckOfCards.flushn = 0;
}