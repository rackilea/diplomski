class MyClass {
    private final Object lock;

    public MyClass(Object lock) {
        this.lock = lock;
    }

    public void setA() {
        synchronized (lock) {
            //...
        }
    }
    public void setB() {
        synchronized (lock) {
            //...
        }
    }
}