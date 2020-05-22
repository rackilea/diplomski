public class AttributeEntry {
    private String name;
    private Object value;

    public AttributeEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public AttributeEntry(String name, ValueObject attributes) {
        this.name = name;
        this.value = attributes;
    }
    /* getters/setters */
}