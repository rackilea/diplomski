public void addCharacter(Card card, int amount, List<Card> cards) {
    for (int i = 0; i < amount; i++) {
        if (card != null) {
            cards.add(card);
        } else {
            Log.e("addCharacter", "Hey! Are you sure you meant to add a null card?");
        }
    }
}