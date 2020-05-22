public class OrderManager {
        private final List<Order>orders;

        public OrderManager() {
          this(new ArrayList<>());//call constructor or doing nothing is another option
        }

        public OrderManager(List<Order> orders) {
            this.orders = orders;
        }


       public List<Order> getOrders(){
           return orders;
       }    

       public void addOrder(Order order){
            orders.add(order);
       }
  }