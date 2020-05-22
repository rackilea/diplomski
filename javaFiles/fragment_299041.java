public class AsyncCachedPreparedStatementCreator implements AsyncPreparedStatementCreator, CqlProvider {

    private final String cql;

    private final Map<Session, com.google.common.util.concurrent.ListenableFuture<PreparedStatement>> cache = new ConcurrentHashMap<>();

    public AsyncCachedPreparedStatementCreator(String cql) {
        this.cql = cql;
    }

    @Override
    public ListenableFuture<PreparedStatement> createPreparedStatement(Session session) throws DriverException {

        com.google.common.util.concurrent.ListenableFuture<PreparedStatement> future = cache.computeIfAbsent(session,
                s -> s.prepareAsync(cql));

        return new GuavaListenableFutureAdapter<>(future, new CassandraExceptionTranslator());
    }

    @Override
    public String getCql() {
        return cql;
    }
}