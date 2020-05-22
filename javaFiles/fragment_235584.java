private static FutureTask<String> task = new FutureTask<String>(new Callable<String>() {

    @Override
    public String call() throws Exception {
        while (!task.isCancelled()) {
            System.out.println("Running...");
            Thread.sleep(1000);
        }
        return "The End";
    }

});

public static void main(String[] args) throws InterruptedException {
    new Thread(task).start();
    Thread.sleep(1500);
    task.cancel(false);
}