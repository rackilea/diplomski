@PostMapping("/submit-order")
public Order submitOrder( @RequestBody Order order) {
  // Remove Order#id to detatch current record and enforce create a new one
  order.getAddress().setId(null);
  return this.orderRepository.save(order);
}