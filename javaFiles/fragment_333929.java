public class Person {

    // ...

    public StringProperty nameProperty() {
        return name ;
    }

    public ObjetProperty<LocalDate> dateProperty() {
        return date ;
    }

    public LocalDate getDate() {
        return dateProperty().get();
    }

    // ...
}