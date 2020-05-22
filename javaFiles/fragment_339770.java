public synchronized void notifyReady() {
    ready = true;
    notifyAll();
}

public synchronized void waitForReady() throws InterruptedException {
    while(!ready)
      wait();
}