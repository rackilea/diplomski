private final StringProperty name = new SimpleStringProperty();

// ...

public StringProperty nameProperty() {
    return name;
}

public String getName() {
    return name.get();
}

public void setName(String name) {
    this.name.set(name);
}