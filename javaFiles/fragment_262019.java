public class Person {
    private long Id;
    private firtName;
    private Address address;
    private Contact contact;

//some setter and getter methods

    public Person(Address address, Contact contact) {
        this.address = address;
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }
}