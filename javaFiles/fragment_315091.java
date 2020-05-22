public class Order {
    private final int orderId;
    private final String productName;
    private final int quantity;
    private final BigDecimal price;

    // Plus constructor, getters etc.
}

private Order parseCsvLine(String line) {
   String[] fields = line.split(",");

   // TODO validation of input/error checking
   final int orderId = Integer.parseInt(fields[0]);
   final String productName = fields[1];
   final int quantity = Integer.parseInt(fields[2]);
   final BigDecimal price = new BigDecimal(fields[3]);

   return new Order(orderId, productName, quantity, price);
}