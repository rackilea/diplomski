Collections.sort(orderBooks, new Comparator<orderbook> {
    @Override
    public int compare(orderbook ob1, orderbook ob2) {
        return o1.getPrice() - o2.getPrice();
    }
});