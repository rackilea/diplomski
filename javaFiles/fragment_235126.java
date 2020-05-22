LinkedHashMap<Order> orderMap = new LinkedHashMap<Order>();
for (Order order: orderList) {
    String orderName = order.getProductName();
    if (orderMap.containsKey(orderName)) {
        Order existing = orderMap.get(orderName);
        existing.setProductQty(existing.getProductQty() + order.getProductQty());
    } else {
        orderMap.put(orderName, order);
    }
}

// optionally, copy back to the list
orderList.clear();
for (Order order: orderMap.values()) {
    orderList.add(order);
}