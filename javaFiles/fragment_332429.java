public class Slot {
    private final StringProperty text = new SimpleStringProperty(this, "text", "");
    public StringProperty textProperty() {
        return text ;
    }
    // ...
}