private String displaySuits() {

    ArrayList<Card> cards = hand.getCards();
    StringBuilder suits = new StringBuilder();

    for (int i = 0; i < cards.size(); i++) {
        Card card = cards[i];
        suits.append(" ");
        suits.append(card.getRank());

        switch (card.getSuit()) {
            case SPADE:
                suits.append((char)'\u2660');
                break;
            case DIAMOND:
                suits.append((char)'\u2666');
                break;
            case CLUB:
                suits.append((char)'\u2663');
                break;
            case HEART:
                suits.append((char)'\u2764');
                break;
        }

    }
    return suits.toString();
}