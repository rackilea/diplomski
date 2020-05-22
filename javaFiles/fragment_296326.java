public static class Person
{
    private final StringProperty name = new SimpleStringProperty("");

    public Person(String n)
    {
        setName(n);
    }

    public StringProperty nameProperty() {
        return name ;
    }

    public final String getName()
    {
        return nameProperty().get();
    }

    public final void setName(String n)
    {
        nameProperty().set(n);
    }
}