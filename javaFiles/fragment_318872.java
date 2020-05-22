public class Customer implements Serializable {
    private String customerID;
    private String name;
    private String street;
    private String city;
    private String postcode;
    private String type;

    protected Customer(String customerID,
                    String name,
                    String street,
                    String city,
                    String postcode,
                    String type) {
        this.customerID = customerID;
        this.name = name;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.type = type;
    }
}