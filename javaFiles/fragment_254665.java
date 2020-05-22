public void Cook extends Thread implements ActionListener {

  private OrderList waiting;

  private OrderList finished;

  private boolean keepCooking;

  public Cook(OrderList waiting, OrderList finished) {
    this.waiting = waiting;
    this.finished = finished;
    this.keepCooking = false;
  }

  public void run() {
    keepCooking = true;
    while (keepCooking) {
      if (orders.size() > 0) {
        try {
          currentOrder = orders.remove(0);
        } catch (Exception e) {
          // someone else emptied the list
        }
      }
      prepareOrder(order);
      if (keepCooking && orders.size() <= 0) {
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
          // back to work
        }
      }
    }
 }

 public void prepareOrder(Order order) {
   try {
      Thread.sleep(Math.random() % 10000);
      finished.add(order);
    } catch (Exception e) {
      waiting.add(order);
    }
  }

  public void goHome() {
    keepCooking = false;
  }
}