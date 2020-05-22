class Cell {
    private Object lock;
    private Object value;

    public void doSomething() {
        synchronized(lock) {
            // something happens here with the value
        }
    }
}