public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new MyFutureTask(task, value);            
    }
}