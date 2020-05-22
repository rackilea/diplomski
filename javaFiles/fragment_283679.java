executor.execute(new Runnable() {
    @Override public void run() {
        new Runnable1().run();
        new Runnable2().run();
    }
});