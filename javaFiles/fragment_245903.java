public final class Employees {
    private final List<Persons> persons;

    public Employees(List<Person> persons) {
        persons = new ArrayList<>();
        for (Person person : persons) {
            persons.add(deepCopy(person));   // If clone is provided 
                                           // and creates a deep copy of person
        }
    }

    public List<Employees> getPersons() {
        List<Person> temp = new ArrayList<>();
        for (Person person : persons) {
            temp.add(deepCopy(person)); // If clone is provided 
                                         // and creates a deep copy of person
        }  
        return temp;
    }

    public Person deepCopy(Person person) {
        Person copy = new Person();  
        // Provide a deep copy of person
        ...
        return copy;
    }
}