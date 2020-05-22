public int getCardValue(Card card) {
    final String rank = card.getRank();
    switch (rank) {
        case "Ace":
            return 1;
        case "King":
        case "Queen":
        case "Jack":
            return 10;
        default:
            return Integer.parseInt(rank);
    }
}