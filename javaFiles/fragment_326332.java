int counter = 0;
for (int rank = 1; rank <= NumberOfRanks; rank++) {
    for (whatSuit = 1; whatSuit <= NumberOfSuits; whatSuit++) {
        newDeck[counter++] = newCard.createCard(rank, whatSuit);
        System.out.println(newDeck[counter - 1]);
    }
}