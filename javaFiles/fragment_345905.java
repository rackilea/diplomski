@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Retryable(
   include = CannotAcquireLockException.class, 
   maxAttempts = 10, 
   backoff = @Backoff(delay = 500, maxDelay = 10000, multiplier = 2, random = true)
)
public @interface ConcurrentDBUpdateRetryPolicy {}