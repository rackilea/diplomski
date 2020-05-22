public class WalkupTicket extends Ticket{
    // Fields
    private double price;

    // Constructor
    public WalkupTicket(int tixNumber){
        super(tixNumber);
        this.price = 50.0;
    }

    public double getPrice() {
        return price;
    }
}