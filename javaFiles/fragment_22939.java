public static class BeanExample2 {

    public final String getName() {
        return this.name.get();
    }

    private final StringProperty name = new SimpleStringProperty();

    public final void setName(String value) {
        this.name.set(value);
    }

    @Override
    public String toString() {
        return "BeanExample2{"
                + "name='" + name.get() + '\''
                + '}';
    }

    public final StringProperty nameProperty() {
        return this.name;
    }
}