public class TxModule extends AbstractModule {

    @Override
    protected void configure() {
        Names.bindProperties(binder(), loadProperties());

        final TransactionManager tm = getTransactionManager();

        bind(DataSource.class).annotatedWith(Real.class).toProvider(H2DataSourceProvider.class).in(Scopes.SINGLETON);
        bind(DataSource.class).annotatedWith(TxAware.class).to(TxAwareDataSource.class).in(Scopes.SINGLETON);
        bind(TransactionManager.class).toInstance(tm);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), new TxMethodInterceptor(tm));
        bind(MyService.class);
    }

    private TransactionManager getTransactionManager() {
        // Get the transaction manager
        return null;
    }

    static class TxMethodInterceptor implements MethodInterceptor {

        private final TransactionManager tm;

        public TxMethodInterceptor(final TransactionManager tm) {
            this.tm = tm;
        }

        @Override
        public Object invoke(final MethodInvocation invocation) throws Throwable {
            // Start tx if necessary
            return invocation.proceed();
            // Commit tx if started here.
        }
    }

    static class TxAwareDataSource implements DataSource {

        static ThreadLocal<Connection> txConnection = new ThreadLocal<Connection>();
        private final DataSource ds;
        private final TransactionManager tm;

        @Inject
        public TxAwareDataSource(@Real final DataSource ds, final TransactionManager tm) {
            this.ds = ds;
            this.tm = tm;
        }

        public Connection getConnection() throws SQLException {
            try {
                final Transaction transaction = tm.getTransaction();
                if (transaction != null && transaction.getStatus() == Status.STATUS_ACTIVE) {

                    Connection cn = txConnection.get();
                    if (cn == null) {
                        cn = new TxAwareConnection(ds.getConnection());
                        txConnection.set(cn);
                    }

                    return cn;

                } else {
                    return ds.getConnection();
                }
            } catch (final SystemException e) {
                throw new SQLException(e);
            }
        }

        // Omitted delegate methods.
    }

    static class TxAwareConnection implements Connection {

        private final Connection cn;

        public TxAwareConnection(final Connection cn) {
            this.cn = cn;
        }

        public void close() throws SQLException {
            try {
                cn.close();
            } finally {
                TxAwareDataSource.txConnection.set(null);
            }
        }

        // Omitted delegate methods.
    }

    static class MyService {
        private final DataSource dataSource;

        @Inject
        public MyService(@TxAware final DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Transactional
        public void singleUnitOfWork() {
            Connection cn = null;

            try {
                cn = dataSource.getConnection();
                // Use the connection
            } catch (final SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    cn.close();
                } catch (final Exception e) {}
            }
        }
    }
}