public class BuyAHouseInc {
    private String firstName;
    private String surname;
    private String address;
    private int budget;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    ...
    public void displayClient() {
        System.out.println("Client Name: " + this.firstName + " " + this.surname);
        System.out.println("Address: " + this.address);
        System.out.println("Budget: " + "€" + this.budget);
    }
}