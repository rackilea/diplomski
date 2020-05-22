public class Customer {
    private long customerId;
    private String name;
    private String address1;
    // ....
    private List<Order> orders;
}

public class Order {
    private long orderNumber;
    private Date orderDate;
    // ... others
    private Customer customer;
}