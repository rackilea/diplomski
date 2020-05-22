public interface PersonView {
    String getFirstName();
    String setFirstName();
}

public void Person implements PersonView {
    private String firstName;

    @Override // This annotation guarantees the interface is correct 
    public String getFirstName() {
        return firstName;
    }

    ...domain methods...
}