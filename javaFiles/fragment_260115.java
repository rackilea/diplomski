package casino;

import java.util.*;

public class Deck extends AbstractDeck<Card> implements CardHolder {
    public Deck() {
        items = new Stack<Card>();
        for (int cardNo = 0; cardNo < 52; cardNo++) {
            items.add(new Card(cardNo));
        }
    }

    public List<Card> getCards() {
        return items;
    }

    public void setCards(Stack<Card> cards) {
        this.items = cards;
    }

    @Override
    public String toString() {
        return String.format("Deck [cards=%s]", items);
    }
}