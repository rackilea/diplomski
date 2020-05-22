private final IntegerProperty id = new SimpleIntegerProperty();

public int getId() {
    return id.get();
}

public void setId(int value) {
    id.set(value);
}

public IntegerProperty idProperty() {
    return id;
}