Task<Void> task = new Task<Void>() {
    @Override
    public Void call() {
        Mul m1 = new Mul();
        m1.run();
        Mul m2 = new Mul();
        m2.run();
        return null ;
    }
};
new Thread(task).start();