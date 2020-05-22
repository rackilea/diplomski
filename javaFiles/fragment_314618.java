new Consumer<Event<Object>>>() {
  public void accept(Event<?> ev) {
    String type = ev.getHeaders().get("group1");
    if("CUSTOMER".equals(type)) {
      // handle customers
    } else if("ORDER".equals(type)) {
      // handle orders
    }
}