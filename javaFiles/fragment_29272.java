@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.PUBLIC_ONLY, setterVisibility = Visibility.PUBLIC_ONLY)
public class MyBean {

    private final StringProperty label = new SimpleStringProperty();

    public final StringProperty labelProperty() {
        return this.label;
    }

    public final String getLabel() {
        return this.labelProperty().get();
    }

    public final void setLabel(final String label) {
        this.labelProperty().set(label);
    }
}