ExecutorService executor = Executors.newFixedThreadPool(nThreads);
executor.submit(new Runnable() {
    String taskSnap = task.toString();
    public void run() {
            try {
                println(task.run(null));
            } catch( InterruptedException e) {
                println("ITC - " + taskSnap + " interrupted ");
            }
    }
});