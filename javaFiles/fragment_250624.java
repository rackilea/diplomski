public class Customer {
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public Customer() {
        // default constructor
    }

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int phoneNumber, String firstName, String lastName) {
        this.phoneNumber = phoneNumber;  
        this.firstName = firstName;
        this.lastName = lastName;
    }

// This is not an overloaded constructor as there is already a constructor of type
// Customer(String, String)

//    public Customer(String lastName, String firstName) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//    }

}