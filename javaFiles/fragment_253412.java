public class Customer {

    private String name;
    private String id;
    private double balance;

    public Customer(){

    }
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void changeBalance(double value) {
        balance = balance + value;
    }
    public String toString() {
        return "name " + name + " id " + id + " balance " + balance;
    }
}