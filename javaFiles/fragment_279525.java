public void addItem(OrderItem item) {
    if (items == null) {
        items = new ArrayList<OrderItem>();
    }
    item.setOrders(this);
    items.add(item);
}