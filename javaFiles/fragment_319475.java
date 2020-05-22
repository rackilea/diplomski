class Tasks {
    public static void main(String[] args) {            

        ExecutorService exec = Executors.newSingleThreadExecutor();
        final Work work = new Work();
        exec.submit(new Runnable() {
                public void run() {
                    work.doWork();
                }
            });
        // later
        exec.submit(new Runnable() {
                public void run() {
                    work.commit();
                }
            });

    }
}