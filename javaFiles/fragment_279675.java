abstract static class UnorderedSliceSpliterator<T, T_SPLITR extends Spliterator<T>> {
    static final int CHUNK_SIZE = 1 << 7;

    // The spliterator to slice
    protected final T_SPLITR s;
    protected final boolean unlimited;
    protected final int chunkSize;
    private final long skipThreshold;
    private final AtomicLong permits;

    UnorderedSliceSpliterator(T_SPLITR s, long skip, long limit) {
        this.s = s;
        this.unlimited = limit < 0;
        this.skipThreshold = limit >= 0 ? limit : 0;
        this.chunkSize = limit >= 0 ? (int)Math.min(CHUNK_SIZE,
            ((skip + limit) / AbstractTask.LEAF_TARGET) + 1) : CHUNK_SIZE;
        this.permits = new AtomicLong(limit >= 0 ? skip + limit : skip);
    }

    UnorderedSliceSpliterator(T_SPLITR s,
                              UnorderedSliceSpliterator<T, T_SPLITR> parent) {
        this.s = s;
        this.unlimited = parent.unlimited;
        this.permits = parent.permits;
        this.skipThreshold = parent.skipThreshold;
        this.chunkSize = parent.chunkSize;
    }