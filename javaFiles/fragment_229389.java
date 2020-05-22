// create User
User user = new User();
// create Order
Order order = new Order();
// and set Order.user
order.setUser(user);
// persist with cascade
em.persist(order);