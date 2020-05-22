public class Card {
    // FIELDS
    // card name
    private final String name;
    // card value (number)
    private final int value;
    // another arbitrary value to demonstrate setter
    private Object arbitraryValue;


    public Card(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public Object getArbitraryValue() {
        return this.arbitraryValue;
    }

    public void setArbitraryValue(Object arbitraryValue) {
        this.arbitraryValue = arbitraryValue;
    }
}