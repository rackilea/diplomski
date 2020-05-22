public class MyForkJoinWorkerThreadFactory
        implements ForkJoinPool.ForkJoinWorkerThreadFactory {
    public final ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new ForkJoinWorkerThread(pool) {};
    }
}