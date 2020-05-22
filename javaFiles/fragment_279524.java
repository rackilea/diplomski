Orders orders = new Orders();
orders.addItem(new OrderItem());
...

session = getSession();
session.save(object);
session.flush()