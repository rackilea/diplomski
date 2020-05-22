Thread t = new Thread(new Runnable() {
    public void run() {
        try {
            while (!t.isInterrupted()) {
               Object item;
               while ((item = queue.take()) == null) {//does not block
                   synchronized (lock) { lock.wait(1000L) } //spin on a lock
               }
               //item is not null
               handle(item);
            }
        } catch (InterruptedException e) { }
    }
});
t.start();