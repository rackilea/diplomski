public void process() {
    synchronized (this) {
        synchronized (next) {
            // manipulate the value of this and of next
        }
    }
}