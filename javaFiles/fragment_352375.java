public abstract class TaxPayer {
     .
     .
     .
     private Address address; // this is attribute.
     .
     .
     .
    //One way is passing the all address attributes in constructor
    public TaxPayer(String TFN, String firstName, String lastName, double income,int streetNumber, String streetName, String suburb,
    String city, String state, int postcode) {
        this.TFN = TFN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
        this.address = new Address(streetNumber, streetName, String suburb,city, state,  postcode);
    }
}