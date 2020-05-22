public class Property {
    private String name, address, type, description;

    public Property(String name, String address, String type, String description) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.description = description;
    }

    public static void main(String[] args) {
        Property[] registeredAssets = new Property[200];

        registeredAssets[0] = new Property("Joe Bloggs", "555 Fake St.", "IMPORTANT", "Lorem Ipsum Dolor");
        // etc.
    }
}