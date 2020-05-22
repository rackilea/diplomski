ExecutorService exec = Executors.newFixedThreadPool(2);

exec.execute(new Runnable() {
    public void run() {
        userProvisioner1.run();
        userProvisioner2.run();
    }
});
exec.execute(new Runnable() {
    public void run() {
        userProvisioner3.run();
        userProvisioner4.run();
    }
});

exec.shutdown();
exec.awaitTermination();