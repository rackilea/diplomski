class Consumer implements Runnable {
    Holder h;
    public Consumer(Holder h) {
        this.h = h;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            int k = h.get();
            if (k != i)
                System.out.println("Got wrong value " + k + "expected value " + i); 
        }
    }
}