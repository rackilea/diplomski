/**
 * The maximum number of concurrent {@link ConsumerInvoker}s running.
 * The {@link ShardConsumer}s are evenly distributed between {@link ConsumerInvoker}s.
 * Messages from within the same shard will be processed sequentially.
 * In other words each shard is tied with the particular thread.
 * By default the concurrency is unlimited and shard
 * is processed in the {@link #consumerExecutor} directly.
 * @param concurrency the concurrency maximum number
 */
public void setConcurrency(int concurrency) {