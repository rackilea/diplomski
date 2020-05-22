public class Test1 {
  public static void main(String[] args) throws Exception {

    Chargeback chargeback = new Chargeback();
    chargeback.setAmount(1234.00);
    chargeback.setCurrency("BHD");
    Order order = new Order();
    order.setAmount(2345.00);
    order.setChargebackObject(chargeback);

    ObjectMapper mapper = new ObjectMapper();
    String toJson = null;
    try {
      toJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Complete Json = " + toJson);

// From Json String to Java Object
ObjectMapper mapper1 = new ObjectMapper();
Order order1 = mapper.readValue(toJson, Order.class);
System.out.println("Order Object -> " + order1);
  }
}