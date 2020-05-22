public void method1() {
    AtomicInteger atomic = new AtomicInteger(5);
    method2(atomic);
    System.out.println(atomic.get()); // prints 5
}

public void method2(AtomicInteger atomic) {
   atomic = new AtomicInteger(7); // reassign, but this does not affect metod1
}