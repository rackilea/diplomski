final BlockingQueue<Result> q = new ArrayBlockingQueue<Result>();
final Callable<Result> action = ...;

s.scheduleAtFixedRate(new Runnable() {
    public void run() {
        q.put(action.call());
    }
}, ...);