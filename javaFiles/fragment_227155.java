Product persitentProduct = ... //some product
Order newOrder = new Order();
newOrder.getProducts().add(persitentProduct);
//at this point : persistentProduct.getOrders().contains(newOrder)==false
entityManager.persist(newOrder);
//at this point nothing has changed on the other side of the relationship:
// i.e. : persistentProduct.getOrders().contains(newOrder)==false