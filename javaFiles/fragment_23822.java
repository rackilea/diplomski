for (Iterator<Card> iterator = hands[1].cards.iterator();
     iterator.hasNext(); ) {
    Card card = iterator.next();
    if (card.suit().ordinal() == 0) {
        hands[0].addSingleCard(card); // Or hands[0].cards.add(card);
        iterator.remove();
    }
}