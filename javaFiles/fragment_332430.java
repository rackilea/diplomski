public class Slot {
    private final StringProperty text = new SimpleStringProperty(this, "text", "");
    public StringProperty textProperty() {
        return text ;
    }
    public final String getText() {
        return textProperty().get();
    }
    public final void setText(String text) {
        textProperty().set(text);
    }

    private final Label label = new Label();

    public Slot(String text) {
        label.textProperty().bind(text);
        setText(text);
    }

    public Node getSlotContents() {
        return label ;
    }
}