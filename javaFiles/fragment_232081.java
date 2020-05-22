public synchronized int get(int number) {
    while (!available) {
        try {
        wait();
        } catch (InterruptedException ie) {
        System.err.println("Interrupted: " + ie.getMessage());
        }
    }
    /*
     * Putting this line here gives expected output because this statement
     * is synchronized due to method synchronization.
     */


    System.out.println("Consumer #" + number + " Consumed: " + item);


    available = false;
    notifyAll();
    return item;
}