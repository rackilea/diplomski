@Service
public class CustomHibernateJpaDialect extends HibernateJpaDialect {

    @Override
    public Object beginTransaction(final EntityManager entityManager,
            final TransactionDefinition definition) throws PersistenceException,
            SQLException, TransactionException {

        Session session = getSession(entityManager);

        if (definition.getTimeout() != TransactionDefinition.TIMEOUT_DEFAULT) {
            session.getTransaction().setTimeout(definition.getTimeout());
        }

        entityManager.getTransaction().begin();

        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                DataSourceUtils.prepareConnectionForTransaction(connection, definition);
                connection.setTransactionIsolation(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
            }
        });

        return prepareTransaction(entityManager, definition.isReadOnly(), definition.getName());
    }

}