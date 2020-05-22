public static AtomicInteger count = new AtomicInteger(0);
@Override
public void run() {
    try {
        Thread.sleep(100);
    } catch (InterruptedException ex) {
        Logger.getLogger(ThreadAdd.class.getName()).log(Level.SEVERE, null, ex);
    }
    ThreadAdd.count.incrementAndGet();
}