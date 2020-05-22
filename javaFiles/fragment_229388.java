// create Order
Order order = new Order();
// create User and Set of orders
User user = new User();
Set<Order> userOrders = new HashSet<Order>();
user.setOrders(userOrders);
userOrders.add(order);
// and set Order.user
order.setUser(user);
// persist with cascade 
em.persist(user);