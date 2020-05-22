public synchronized Color pickColor() {
    // code to create and show the dialog
    EventQueue tempEventQueue = new EventQueue();
    Toolkit.getDefaultToolkit().getSystemEventQueue().push(tempEventQueue);
    try {
        wait();
    } catch (InterruptedException ex) {
        // stop waiting on interrupt
    } finally {
        tempEventQueue.pop();
    }
    // return colour from dialog
}