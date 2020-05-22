@State(Scope.Benchmark)
public class SpeedTest {
private static final int NUM_TASKS = 1000000;

    private static List<ParallelCollatz> tasks = buildTasks();

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @SuppressWarnings("unused")
    public long singleThread() throws Exception {
        ThreadPoolExecutor executorOneThread = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        return measureTasks(executorOneThread, tasks);
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @SuppressWarnings("unused")
    public long multipleThreads() throws Exception {
        ThreadPoolExecutor executorMultipleThread = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        return measureTasks(executorMultipleThread, tasks);
    }

    private static long measureTasks(ThreadPoolExecutor executor, List<ParallelCollatz> tasks) throws InterruptedException, ExecutionException {
        long sum = runTasksInExecutor(executor, tasks);
       return sum;
    }

    private static long runTasksInExecutor(ThreadPoolExecutor executor, List<ParallelCollatz> tasks) throws InterruptedException, ExecutionException {
        List<Future<Long>> futures = new ArrayList<>(NUM_TASKS);
        for (int i = 0; i < NUM_TASKS; i++) {
            Future<Long> f = executor.submit(tasks.get(i));
            futures.add(f);
        }
        executor.shutdown();

        boolean tempFirst = false;
        try {
            tempFirst = executor.awaitTermination(5, TimeUnit.HOURS);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        long sum = 0l;
        for (Future<Long> f : futures) {
            sum += f.get();
        }
        //System.out.println(sum);
        return sum;
    }

    private static List<ParallelCollatz> buildTasks() {
        List<ParallelCollatz> tasks = new ArrayList<>();
        for (int i = 1; i <= NUM_TASKS; i++) {
            ParallelCollatz task = new ParallelCollatz((long) (i + NUM_TASKS));

            tasks.add(task);

        }
        return tasks;
    }

}