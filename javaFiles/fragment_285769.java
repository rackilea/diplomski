Thread t1 = new Thread(new Runnable() {

    @Override
    public void run() {
        write(..);
    }
});
Thread t2 = new Thread(new Runnable() {

    @Override
    public void run() {
        read(..);
    }
});
t1.start();
t2.start();