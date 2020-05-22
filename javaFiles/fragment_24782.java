public void addWeight() throws InterruptedException {
    lock.lock();
    try {
        while (cart.getWeight() == (cart.getCapacity() - 1)) {
            whenFull.await();  //<--   ADDER waits here 
        }
        cart.addWeight();
        System.out.println("++ weight is: " + cart.getWeight());
        whenEmpty.signalAll(); //<-- Never called since both are waiting
        Thread.sleep(500);
    } finally {
        lock.unlock();
    }
}

public void reduceWeight() throws InterruptedException {
    lock.lock();
    try {
        while (cart.getWeight() == 0) {
            whenEmpty.await(); //<-- REDUCER waits here
        }
        cart.reduceWeight();
        System.out.println("-- weight is: " + cart.getWeight());
        whenFull.signalAll(); //<-- Never called since both are waiting
        Thread.sleep(500);
    } finally {
        lock.unlock();
    }
}