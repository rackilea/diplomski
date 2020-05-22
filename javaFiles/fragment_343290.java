List<String> itemNos = new ArrayList<String>();
List<String> itemNames = new ArrayList<String>();
for (Order order : orderHistory.getOrders()) {
  for (OrderItem item : order.getItems()) {
    itemNos.add(item.getItemNo());
    itemNames.add(item.getItemName());
  }
}