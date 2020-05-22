public Customers extends Thread {

  private OrderList orders;

  public Customers(OrderList orders) {
    this.orders = orders;
  }

  public void run() {
    int number = 0;
    while (true) {
      number++;
      try {
        Thread.sleep(Math.random() % 10000)
        orders.add(new Order(String.format("Order %d", number)));
      } catch (Exception e) {
        return;
      }
    }
  }
}