public class CustomerOrder {
    private final Customer customer;
    private final List<Order> orders;
    public CustomerOrder(Customer customer) {
        super();
        this.customer = customer;
        this.orders = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Order> getOrders() {
        return orders;
    }
}