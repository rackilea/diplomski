ArrayList<String> cards = new ArrayList();
while (cards.size() < 4) {
    String card = randomizedCard();
    if (!cards.contains(card)) {
        cards.add(card);
    }
}