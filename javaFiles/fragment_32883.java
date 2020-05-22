Task<Void> task1 = new Task<Void>() {
    @Override
    public Void call() {
        new Mul().run();
        return null ;
    }
};

Task <Void> task2 = new Task<Void>() {
    @Override
    public Void call() {
        new Mul().run();
        return null ;
    }
};

task1.setOnSucceeded(e -> new Thread(task2).start());

new Thread(task1).start();