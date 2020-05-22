boolean done = false;

public synchronized setDone() {

    done = true;

    this.notifyAll();
}

public synchronized waitUntilDone() {

     while (!done) {

        try {
             this.wait();

        } catch (InterruptedException ignore) {
             // log.debug("interrupted: " + ignore.getMessage());
        }
     }
}