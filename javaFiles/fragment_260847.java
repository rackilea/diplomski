public class MyControl extends Control {

    @Override
    protected Skin<?> createDefaultSkin() {
        return new MyControlSkin(this);
    }

    private final StringProperty text = new SimpleStringProperty();

    public final String getText() {
        return this.text.get();
    }

    public final void setText(String value) {
        this.text.set(value);
    }

    public final StringProperty textProperty() {
        return this.text;
    }

}