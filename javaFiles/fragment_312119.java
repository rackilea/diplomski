public void run() {
    while (true) {
        if (/*counterperson has 23 counts*/) { break; }
        synchronized (/*your switchroom object here*/) { // this makes it so only one person can flip switches at a time
            // use an if/else to figure out if this person is the "counter" person
            // try to flip a switch/do stuff based on required logic regarding if he is
            // the counter person
        }

        try {
            wait(100); // or however long you want to wait before trying again
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}