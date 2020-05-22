public final class PooledConnection extends DelegatingConnection {
    private final ConnectionPool mPool;
    public PooledConnection(final Connection theConnection, final ConnectionPool thePool) {
        super(theConnection);
        mPool = thePool;
    }

    @Override
    public void close() {
        super.close();
        mPool.release(getConnection());
    }
}