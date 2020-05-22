public void push(Card c) {
  cards.add(c);
}

public Card pop() {
  Card c = cards.get(cards.size() - 1);
  cards.remove(cards.size() - 1);
  return c;
}

public Card peek() {
  return cards.get(cards.size() - 1);
}