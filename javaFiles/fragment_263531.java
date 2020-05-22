public class Community {

    private List<Person> people;

    @XmlElementRef
    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    } 

}