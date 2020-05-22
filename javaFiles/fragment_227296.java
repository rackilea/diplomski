public class CancellableTaskTest {

    public static void main(String[] args) throws Exception {
        CancellableThreadPoolExecutor threadPoolExecutor = new CancellableThreadPoolExecutor(0, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        long startTime = System.currentTimeMillis();
        Future<String> future = threadPoolExecutor.submit(new CancellableTask());
        while (System.currentTimeMillis() - startTime < 100) {
            Thread.sleep(10);
        }
        System.out.println("Trying to cancel task");
        future.cancel(true);
    }
}

class CancellableThreadPoolExecutor extends ThreadPoolExecutor {

    public CancellableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new CancellableFutureTask<T>(callable);
    }
}

class CancellableFutureTask<V> extends FutureTask<V> {

    private WeakReference<CancellableTask> weakReference;

    public CancellableFutureTask(Callable<V> callable) {
        super(callable);
        if (callable instanceof CancellableTask) {
            this.weakReference = new WeakReference<CancellableTask>((CancellableTask) callable);
        }
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean result = super.cancel(mayInterruptIfRunning);
        if (weakReference != null) {
            CancellableTask task = weakReference.get();
            if (task != null) {
                try {
                    task.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }
}

class CancellableTask implements Callable<String> {

    private volatile boolean cancelled;
    private final Object lock = new Object();
    private LinkedList<Object> cancellableResources = new LinkedList<Object>();

    @Override
    public String call() throws Exception {
        if (!cancelled) {
            System.out.println("Task started");
            // write file
            File file = File.createTempFile("testfile", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            synchronized (lock) {
                cancellableResources.add(writer);
            }
            try {
                long lineCount = 0;
                while (lineCount++ < 100000000) {
                    writer.write("This is a test text at line: " + lineCount);
                    writer.newLine();
                }
                System.out.println("Task completed");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.close();
                file.delete();
                synchronized (lock) {
                    cancellableResources.clear();
                }
            }
        }
        return "done";
    }

    public void cancel() throws Exception {
        cancelled = true;
        Thread.sleep(1000);
        boolean success = false;
        synchronized (lock) {
            for (Object cancellableResource : cancellableResources) {
                if (cancellableResource instanceof Closeable) {
                    ((Closeable) cancellableResource).close();
                    success = true;
                }
            }
        }
        System.out.println("Task " + (success ? "cancelled" : "could not be cancelled. It might have completed or not started at all"));
    }
}