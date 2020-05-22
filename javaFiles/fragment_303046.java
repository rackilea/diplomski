public class Order {
    private static int totalOrdersPlaced;
    public final int orderID;

    public Order() {
        totalOrdersPlaced++;
        orderID = totalOrdersPlaced;
    }
}