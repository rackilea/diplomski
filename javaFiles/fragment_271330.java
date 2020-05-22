public class Order {
   // properties, constructor...

   public OrderResult executeOrder() {
      // just do it
   }
   public String asXML() {
      // generate the order as an XML string
   }
}    

public class GroupOfOrders {
   private List<Order> orders = new ArrayList<>();

   public void addOrder(Order o) {
      // do some checking on order
      orders.add(order);
   }

   public GroupedOrderResult executeAllOrders() {
      GroupedOrderResult result = new GroupedOrderResult();
      for (Commande c : commandes) {
         OrderResult res = c.executeOrder();
         result.add(c, res);
      }
      return result;
   }

   List<Order> getOrders() { return orders; }
}