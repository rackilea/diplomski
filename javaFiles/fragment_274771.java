public class Person {

    private BooleanProperty accepted;

    public Person(String name, boolean single) {
        this.accepted = new SimpleBooleanProperty(single);
        ... 
    }

    public BooleanProperty acceptedProperty() {
        return accepted;
    }

    public boolean isAccepted() {
        return acceptedProperty().get();
    }

    ....