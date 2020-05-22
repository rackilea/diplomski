package casino;

import java.util.*;

public class Hand extends AbstractDeck<Card> implements CardHolder {
    public Hand() {
        items = new Stack<Card>();
    }

    public List<Card> getCards() {
        return items;
    }

    public void setCards(Stack<Card> cards) {
        this.items = cards;
    }

    @Override
    public String toString() {
        return String.format("Hand [cards=%s]", items);
    }
}