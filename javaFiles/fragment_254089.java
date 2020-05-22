public class Contact implements Comparable<Contact> {

    private String name;
    private String phone;
    private Address address;

    public int compareTo(Contact other) {
        return name.compareTo(other.name);
    }

    // Add/generate getters/setters and other boilerplate.
}