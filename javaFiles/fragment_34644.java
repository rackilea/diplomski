class ThreadTask<T> implements Runnable {
    private T value;

    public ThreadTask(T value) {
        this.value = value;
    }

    public void run() {
        // update based on value
    }
}

...

ExecutorService exec = Executors.newSingleThreadExecutor();
exec.submit(new ThreadTask<String>("asdf"));
exec.submit(new ThreadTask<Integer>(1));