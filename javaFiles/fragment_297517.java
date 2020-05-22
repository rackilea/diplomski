public class TaskTimer {
    public static void main(String[] args) {
        ScheduledExecutorService svc = Executors.newScheduledThreadPool(0);
        svc.schedule(new Task(svc), 2, TimeUnit.SECONDS);
    }
}

class Task implements Callable<Result> {

    private ScheduledExecutorService svc;

    public Task(ScheduledExecutorService svc) {
        this.svc = svc;
    }

    @Override
    public Result call() throws Exception {
        Result result = compute();
        Task t = nextTask(result);
        svc.schedule(t, 2, TimeUnit.SECONDS);
        return result;
    }

    private Task nextTask(Result result) {
        return new Task(svc);
    }

    private Result compute() {
        System.out.println("Computing Result");
        return new Result();
    }

}

class Result {

}