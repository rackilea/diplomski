public class Children {

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    @XmlElement(name="person") // MISSING ANNOTATION
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}