public void run() {
    synchronized (mutex) {
        for (int i = 0; i < 1000000; i++) counter = counter + 1;
        for (int i = 0; i < 1000000; i++) counter = counter - 1;
    }
    // Here the current thread exited the sync block and some other thread get into this block  
    // and started incrementing the counter

    System.out.print(counter + " "); // your thread prints incremented counter
}