@Singleton
public class StateModel {
    // Properties
    private final StringProperty name = new SimpleStringProperty();

    // Property Getter
    public StringProperty nameProperty() { return this.name; }
}