private int counter = 0;
public void add(Order o) {
   counter += 1;
   String newCounter = Integer.toString(counter);
   this.orders.put(newCounter, o);
}