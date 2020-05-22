public class UserInfo {

    private final StringProperty name = new SimpleStringProperty() ;
    private final StringProperty department = new SimpleStringProperty() ;
    // etc...

    public StringProperty nameProperty() {
        return name ;
    }

    public final String getName() {
        return nameProperty().get();
    }

    public final void setName(String name) {
        nameProperty().set(name);
    }

    // etc...
}