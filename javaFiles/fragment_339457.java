Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        B b = new B();
        b.doSomethingLong();
    }
});