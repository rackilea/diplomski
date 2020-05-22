private static final int CORE_POOL_SIZE = 5;
private static final int MAXIMUM_POOL_SIZE = 128;
private static final int KEEP_ALIVE = 1;

... ...

/**
 * An {@link Executor} that can be used to execute tasks in parallel.
 */
public static final Executor THREAD_POOL_EXECUTOR
        = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);