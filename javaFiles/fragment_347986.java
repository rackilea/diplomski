int sum = 0;
for(int i = 0; i<13; i++) {
    Card c = deck.getNextCard();
    textArea.append(c.toString()+"\n");
    sum += c.getRank();
}