public class OrderManager {
    private ArrayList<Order>orders;
    public OrderManager() {
      this(new ArrayList<>());//call constructor
    }

    public OrderManager(ArrayList<Order> orders) {
        this.orders = orders;
    }
  .
  .
   //more methods here for example getters and/or setters for orders
}