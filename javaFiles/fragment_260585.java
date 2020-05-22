@Transactional
public void storeOrderInDB() {

Order order = new Order(currentDate(), currentUser); //date,user

OrderItem orderItem = new OrderItem();
orderItem.setBook(currentBook);
orderItem.setQuantity(qty);
orderItem.setTotalPrice(getTotalCost(qty, unitPrice));
//orderItemService.addOrderItem(orderItem);
Set<OrderItem> orderItemSet=order.getOrderItems();
orderItemSet.add(orderItem);
order.setOrderItems(orderItemSet);
orderService.addOrder(order);
}