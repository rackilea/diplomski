public class Contact {

    private String name;
    private String phone;
    private Address address;

    // ...

    public static Comparator<Contact> COMPARE_BY_PHONE = new Comparator<Contact>() {
        public int compare(Contact one, Contact other) {
            return one.phone.compareTo(other.phone);
        }
    };

    public static Comparator<Contact> COMPARE_BY_ADDRESS = new Comparator<Contact>() {
        public int compare(Contact one, Contact other) {
            return one.address.compareTo(other.address);
        }
    };

}