public void buildDeck() throws IOException {

    List<String> cardLines = Files.readAllLines(Paths.get("cards.txt"));

    for (int i = 0; i < cardLines.size(); i += 2) { //if lines read are smaller than file then read for another card
        cards.add(new Card(cardLines.get(i), cardLines.get(i + 1))); //add new card to cards array
    }
}

public List<Card> getDeck() {
     return cards;
}