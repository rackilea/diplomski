public class Card {
    private final CardType cardType;
    private final String cardName;
    private final Map<String, String> properties = new HashMap<>();

    Card(final CardType cardType, final String cardName) {
        this.cardType = cardType;
        this.cardName = cardName;
    }

    public Card setProperty(final String name, final String value) {
        properties.put(name, value);
        return this;
    }

    public String getProperty(final String name) {
        return properties.get(name);
    }
}