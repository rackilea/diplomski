public class Person {
    private final StringProperty ID;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty prevSurname;
    private final StringProperty patronymic;
    ...

    @XmlAttribute(name="ID")
    public String getID() {
        return ID.get();
    }
    public void setID(String ID) {
        this.ID.set(ID);
    }

    public StringProperty IDProperty() {
        return ID;
    }