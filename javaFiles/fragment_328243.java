// Card.java
public class Card {
    // An array containing information about cards in general should be static.
    private static String[] NAMES = new String[]{"Card 1", "Card 2"/*, ...*/};
    private static String[] TEXTS = new String[]{"Card 1 description", "Card 2 description"/*, ...*/};

    // These values, which are unique to each card, are not static.
    private int name, text; 

    public Card(int name, int text) {
        this.name = name;
        this.text = text;
    }

    public String toString() {
        // Instead of having cardToString(), we use this canonical function.
        return Card.NAMES[this.name] + ' ' + Card.TEXTS[this.description];
    }
}

// Deck.java
public class Deck {
    // Since there could be many decks, each with their own cards, this isn't static either.
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.cards.size(); i++) {
            str += this.cards.get(i) + "\n";
        }
        return str;
    }
}