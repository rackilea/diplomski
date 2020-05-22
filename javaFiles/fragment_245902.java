public final class Employees {
    private final List<Persons> persons;

    public Employees(List<Person> persons) {
        persons =  Collections.unmodifiableList(new ArrayList<>(persons));
    }

    public List<Employees> getPersons() {
        return persons;
    }
}