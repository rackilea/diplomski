/**
 * Executor which ensures incoming tasks are executed in queues according to provided key (see {@link Task#getOrder()}).
 */
public class TasksOrderingExecutor {

    public interface Task extends Runnable {
        /**
         * @return ordering value which will be used to sequence tasks with the same value.<br>
         * Tasks with different ordering values <i>may</i> be executed in parallel, but not guaranteed to.
         */
        String getOrder();
    }

    private static class Worker implements Runnable {

        private final LinkedBlockingQueue<Task> tasks = new LinkedBlockingQueue<>();

        private volatile boolean stopped;

        void schedule(Task task) {
            tasks.add(task);
        }

        void stop() {
            stopped = true;
        }

        @Override
        public void run() {
            while (!stopped) {
                try {
                    Task task = tasks.take();
                    task.run();
                } catch (InterruptedException ie) {
                    // perhaps, handle somehow
                }
            }
        }
    }

    private final Worker[] workers;
    private final ExecutorService executorService;

    /**
     * @param queuesNr nr of concurrent task queues
     */
    public TasksOrderingExecutor(int queuesNr) {
        Preconditions.checkArgument(queuesNr >= 1, "queuesNr >= 1");
        executorService = new ThreadPoolExecutor(queuesNr, queuesNr, 0, TimeUnit.SECONDS, new SynchronousQueue<>());
        workers = new Worker[queuesNr];
        for (int i = 0; i < queuesNr; i++) {
            Worker worker = new Worker();
            executorService.submit(worker);
            workers[i] = worker;
        }
    }

    public void submit(Task task) {
        Worker worker = getWorker(task);
        worker.schedule(task);
    }

    public void stop() {
        for (Worker w : workers) w.stop();
        executorService.shutdown();
    }

    private Worker getWorker(Task task) {
        return workers[task.getOrder().hashCode() % workers.length];
    }
}