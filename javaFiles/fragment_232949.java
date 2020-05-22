class TestProcess {
    private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        List<String> out = new ArrayList<>();
        IntegerCallable ic = new TestProcess.IntegerCallable(out);
        int returnVal = timedCall(ic);
    }

    private static <T> T timedCall(Callable<T> c) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<T> task = new FutureTask<>(c);
        THREAD_POOL.execute(task);
        return task.get(3, TimeUnit.SECONDS);
    }


    public static class IntegerCallable implements Callable<Integer> {
        private final List<String> output;
        private Process process;

        public IntegerCallable(List<String> out) {
            this.output = out;
        }

        public Integer call() throws Exception {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "execCommand/", "-Djava.security.manager", "-Djava.security.policy=execCommand/exec.policy", "-Xmx64M", "Exec");
            pb.redirectErrorStream(true);
            process = pb.start();

            try (final Scanner scan = new Scanner(process.getInputStream())) {
                while (scan.hasNext())
                    output.add(scan.nextLine());
            }
            return process.exitValue();
        }
    }
}