public class ThreadPool3 {
        private static int maxNumWorkerThreads;
        private static ExecutorService workerPool = null;
        private static ExecutorService helperPool = null;

        public static void initThreadPool(int maxNumWorkerThreads_) {
                int availProcessors = Runtime.getRuntime().availableProcessors();
                if (maxNumWorkerThreads_ <= 0) {
                        maxNumWorkerThreads_ = availProcessors;
                }
                maxNumWorkerThreads = maxNumWorkerThreads_;

                if (availProcessors != maxNumWorkerThreads) {
                        System.out.println("WARN: maxNumWorkerThreads (" + maxNumWorkerThreads + ") != availProcessors (" + availProcessors + ")");
                }
                workerPool = Executors.newFixedThreadPool(maxNumWorkerThreads);
                BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>();
                helperPool = new ThreadPoolExecutor(0, 4 * maxNumWorkerThreads, 60, TimeUnit.MINUTES, workQueue, Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.CallerRunsPolicy());
        }


        public static abstract class HardWork implements Callable<Void> {
                @Override
                public abstract Void call() throws Exception;
        }

        public static void doHardWork(List<HardWork> tasks) throws Exception {
                workerPool.invokeAll(tasks);
        }


        /**
        * fake ForkJoinPoolInterface:
        *
        */
        public static abstract class FakeRecursiveTask<T> implements Callable<T> {
                private Future<T> resultFuture = null;

                /**
                * fake interface:
                */
                public abstract T compute();

                /**
                * fake interface:
                */
                public T invoke() {
                        return compute();
                }

                /**
                * fake interface:
                */
                public void fork() {
                        resultFuture = helperPool.submit(this);
                }

                /**
                * fake interface:
                */
                public T join() {
                        try {
                                return resultFuture.get();
                        }
                        catch (Exception e) {
                                throw new RuntimeException(e);
                        }
                }

                @Override
                public T call() throws Exception {
                        return compute();
                }
        }


        public static void shutdownThreadPool() {
                if (workerPool != null) {
                        workerPool.shutdown();
                }
                if (helperPool != null) {
                        helperPool.shutdown();
                }
        }
}