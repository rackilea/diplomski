public class Transaction {
    private final double quantity;
    private final BigDecimal price;
    private String transactionID;

    public Order(double quantity, BigDecimal price) {
        this.transactionID = this.generateID();
        this.quantity = quantity;
        this.price = price;
    }
}