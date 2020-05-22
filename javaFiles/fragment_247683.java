private void waitForInput() {
    String input = "";
    // Though we are not waiting infinitely without timeout, we still need
    // while loop.
    // Since JVM in some cases might wake-up thread without notify calls,
    // this is called "spurious" wake-ups.
    synchronized (this) {
        while (input.equals("")) {
            System.out.println("Waiting...");
            try {
                this.wait();//Wait infinitely, or till notify called.
//Lock is released but current thread is blocked, so call on some Async thread if required.
            } catch (Exception e) {
                System.out.println("failed to wait.");
                e.printStackTrace();
            }
        }
    }
    System.out.println("Finished waiting.");
}

//Your twitter bot should call this method, when new input received.
public void wakeup(String input) {
    synchronized (this) {
        this.input = input;
        notifyAll();
    }
}