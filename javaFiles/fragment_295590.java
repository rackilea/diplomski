final AtomicInteger value = new AtomicInteger(10);
Runnable r1 = new Runnable() {
    public void run() {
        // random stuff using value
    }
}
Runnable r2 = new Runnable() {
   public void run() {
        value.decrementAndGet();
    }
}