Collections.sort(ordersLists, new Comparator <OrdersList> () {
    @Override
    public int compare(OrdersList ordersList, OrdersList t1) {
        return ordersList.getOrderID().compareToIgnoreCase(t1.getOrderID()) * -1;
    }
});