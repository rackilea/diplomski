public static class Item {

    // property only assigned once
    private final StringProperty type;

    public Item(String type) {
        this.type = new SimpleStringProperty(type);
    }

    // getter for value wrapped in property
    public final String getType() {
        return this.type.get();
    }

    // setter for value wrapped in property
    public final void setType(String value) {
        this.type.set(value);
    }

    // property getter
    public final StringProperty typeProperty() {
        return this.type;
    }
}

public static Color typeToColor(String type) {
    if (type == null) {
        return Color.WHITESMOKE;
    }
    switch (type) {
        case "bad":
            return Color.RED;
        case "good":
            return Color.LIME;
        default:
            return Color.WHITESMOKE;
    }
}