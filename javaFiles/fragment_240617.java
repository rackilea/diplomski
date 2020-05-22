public int calculateTableBill(int tableId, OrderList orderList) {
    int billTotal = 0;
    for (Order order : orderList.getOrderList()) {
        if (order.getTableId() == tableId) {
            billTotal += order.getPrice()
        }
    }
    return billTotal ;
}