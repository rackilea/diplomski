Session createSession = HibernateUtil.getSessionFactory().openSession();
createSession.beginTransaction();

final Customer customer = new Customer();
Map<String, Order> orders = new HashMap<String, Order>() {{
    put("one", new Order("one", customer));
    put("two", new Order("two", customer));
    put("three", new Order("three", customer));
}};

for (Order order : orders.values())
    order.setCustomer(customer);

customer.setOrders(orders);
createSession.save(customer);

createSession.getTransaction().commit(); //HERE THE EXCEPTION COMES
createSession.close();