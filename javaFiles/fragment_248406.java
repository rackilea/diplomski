public class ErrorHandlingLoadingCacheFactory {

    private final Ticker ticker;

    @Autowired
    public ErrorHandlingLoadingCacheFactory(Ticker ticker) {
        this.ticker = ticker;
    }

    /**
     * Create an in-memory LoadingCache
     *
     * @param cacheName the name of the cache
     * @param duration how long to keep values in the cache before attempting to refresh them
     * @param timeUnit the unit of time of the given duration
     * @param valueResolver the method to call to get a value to load into the cache for a given key
     * @param <T> the type of object to store into the cache
     * @return the newly created cache
     */
    public <T> LoadingCache<String, T> buildCache(String cacheName,
                                                        long duration,
                                                        TimeUnit timeUnit,
                                                        Function<String, T> valueResolver) {
        return buildCache(cacheName, duration, timeUnit, valueResolver, ForkJoinPool.commonPool());
    }

    /**
     * Create an in-memory LoadingCache
     *
     * @param cacheName the name of the cache
     * @param duration how long to keep values in the cache before attempting to refresh them
     * @param timeUnit the unit of time of the given duration
     * @param valueResolver the method to call to get a value to load into the cache for a given key
     * @param executor the executor for the cache to use
     * @param <T> the type of object to store into the cache
     * @return the newly created cache
     */
    protected <T> LoadingCache<String, T> buildCache(String cacheName,
                                                     long duration,
                                                     TimeUnit timeUnit,
                                                     Function<String, T> valueResolver,
                                                     Executor executor) {
        return Caffeine.newBuilder()
                .refreshAfterWrite(duration, timeUnit)
                .ticker(ticker)
                .executor(executor)
                .build(new ErrorHandlingCacheLoader<>(cacheName, valueResolver));
    }
}