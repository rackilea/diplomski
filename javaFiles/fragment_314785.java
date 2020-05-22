static interface TaskBlocker {

    void acquire();

    void release();
}

static class Worker implements Runnable {

    final TaskBlocker taskBlocker;

    public Worker(TaskBlocker taskBlocker) {
        this.taskBlocker = taskBlocker;
    }

    @Override
    public void run() {
        taskBlocker.acquire();
        try {
            //do stuff
        } finally {
            taskBlocker.release();
        }
    }
}

public static void main(String[] args) {

    final int numThreads = 10;
    final ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
    final TaskBlocker taskBlocker;
    boolean myflag = true;
    if (myflag) {
        taskBlocker = new TaskBlocker() {
            final Lock lock = new ReentrantLock();

            @Override
            public void acquire() {
                lock.lock();
            }

            @Override
            public void release() {
                lock.unlock();
            }
        };
    } else {
        taskBlocker = new TaskBlocker() {
            @Override
            public void acquire() {
            }

            @Override
            public void release() {
            }
        };
    }
    final Worker worker = new Worker(taskBlocker);
    executorService.submit(worker);
}