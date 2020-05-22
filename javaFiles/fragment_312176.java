class List {

    Person[] persons;
    int count;

    public List() {
        this(100);
    }

    public List(int initialCapacity) {
        persons = new Person[initialCapacity];
    }

    public int numberOfPersons() {
        return count;
    }

    public void add(Person person) {
        checkUniqueId(person);
        if (count >= persons.length) {
            // Enlarge array
            persons = Arrays.copyOf(persons, persons.length + 100);
        }
        persons[count] = person;
        ++count;
    }

    private void checkUniqueId(Person person) {
        for (int i = 0; i < count; ++i) {
            if (persons[i].id == person.id) {
                throw new IllegalArgumentException("Already a person with id "
                    + person.id);
            }
        }
    }

    public void remove(int personId) {
        for (int i = 0; i < count; ++i) {
            if (persons[i].id == personId) {
                --count;
                persons[i] = persons[count];
                persons[count] = null;
                return;
            }
        }
        throw new IllegalArgumentException("No person known with id "
            + personId);
    }
}

public class Person {

    public String fn;
    public String ln;
    public Date dob;
    public int id; // Must be unique

    public Person() {
    }

    public Person(String fn, String ln, Date dob, int id) {
        this.fn = fn;
        this.ln = ln;
        this.dob = dob;
        this.id = id;
    }
}

public class SimplePersonDataBase {

    private List list;
    private int nextPersonId;

    public boolean add(Person personadd) {
        personadd.id = nextPersonId;
        ++nextPersonId;
        list.add(personadd);
    }
}