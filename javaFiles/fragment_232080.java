public synchronized void set(int item, int number) {
    while(available) {
        try {
        wait();
        } catch (InterruptedException ie) {
        System.err.println("Interrupted: " + ie.getMessage());
        }
    }

    this.item = item;


    /* Putting this line here gives expected output because this   
     * statement is synchronized due to method synchronization.  
     */
        System.out.println("Producer #" + number + " Produced: " + item);            

        available = true;
        notifyAll();
}