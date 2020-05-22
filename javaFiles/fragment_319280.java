public class HelloWorldForm extends ActionForm{
    private List<PersonForm> persons = new ArrayList<>();

    public List<PersonForm> getPersons() {
        return persons;
    }
    public void setPersons(List<PersonForm> persons) {
        this.persons = persons;
    }
}