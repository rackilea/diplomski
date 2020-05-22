final Thread first = new Thread(r);
first.start();

Thread second = new Thread(new Runnable() {

    @Override
    public void run() {
        first.join();
        // TODO Auto-generated method stub
        running = false;
    }
});
second.start();