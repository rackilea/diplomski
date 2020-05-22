* <p>Multiple {@link Benchmark} methods can be bound in the execution group
 * to produce the asymmetric benchmark. Each execution group contains of one
 * or more threads. Each thread within a particular execution group executes
 * one of {@link Group}-annotated {@link Benchmark} methods. The number of
 * threads executing a particular {@link Benchmark} defaults to a single thread,
 * and can be overridden by {@link GroupThreads}.</p>
 *
 * <p>Multiple copies of an execution group may participate in the run, and
 * the number of groups depends on the number of worker threads requested.
 * JMH will take the requested number of worker threads, round it up to execution
 * group size, and then distribute the threads among the (multiple) groups.
 * Among other things, this guarantees fully-populated execution groups.</p>

 * <p>For example, running {@link Group} with two {@link Benchmark} methods,
 * each having {@link GroupThreads}(4), will run 8*N threads, where N is an
 * integer.</p>