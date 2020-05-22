package model;

public class Person {
    private String firstName;
    private String lastName;
    // What else means something to your problem?  Birthday?
    // Constructors, getters (make them immutable), equals/hashCode
}

public class Address {
    private String street;
    private String city;
    private String county;
    private String postalCode;
    // Constructors, getters (make them immutable), equals/hashCode
}

public class AddressBook {
    private Map<Person, Address> contacts = new ConcurrentHashMap<Person, Address>();

    public void addContact(Person p, Address a) {
        this.contacts.put(p, a);
    }

    public void removeContact(Person p) {
        this.contacts.remove(p);
    }

    public Collection<Person> findAllContacts() {
        return new Collections.unmodifiableCollection(this.contacts.keySet());
    }

    public boolean hasContact(Person p) {
        return this.contacts.contains(p);
    }
    // etc.
}