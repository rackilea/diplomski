public class Sieve {

    // Number of workers. Make it static for simplicity.
    private static final int THREADS = 4;

    // array must be shared between master and workers threads so make it class property.
    private boolean[] isComposite;
    // Create blocking queue with size equal to number of workers.
    private BlockingQueue<Job> jobs = new ArrayBlockingQueue<Job>(THREADS);
    private Semaphore semaphore = new Semaphore(0);
    // Create executor service in order to reuse worker threads. 
    // we can use just new Thread(new Worker()).start(). But using thread pools more effective.
    private ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public void runEratosthenesSieve(int upperBound) {
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        isComposite = new boolean[upperBound + 1];

        // Start workers.
        for (int i = 0; i < THREADS; i++) {
            executor.submit(new Worker());
        }
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");
                for (int n=1; n<= THREADS; n++) {
                    int from;
                    if (n == 1) {
                        from = m * m;
                    } else {
                        from = (n-1)*upperBound/THREADS;
                    }
                    Job job = new Job(from, n*upperBound/threads, m);
                    // Submit job to queue. We don't care which worker gets the job.
                    // Important only that only 1 worker get the job. But BlockingQueue does all synchronization for us.
                    jobs.put(job);
                }
                // Wait until all jobs are done.
                semaphore.acquire(THREADS);
            }
        }
        for (int i = 0; i < n; i++) {
            // put null to shutdown workers.
            jobs.put(null);
        }
        for (int m = upperBoundSquareRoot; m <= upperBound; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");
            }
        }
    }

    private class Job {
        public int from, to, step;

        public Job(int from, int to, int step) {
            this.from = from;
            this.to = to;
            this.step = step;
        }
    }

    private Worker implements Runnable {
        while (true) {
            Job job = jobs.take();
            // null means workers must shutdown
            if (job == null) {
                return;
            }
            for (int i = job.from; i <= job.to; i += job.step) {
                isComposite[i] = true;
            }
            // Notify master thread that a job was done.
            semaphore.release();
        }
    }
}