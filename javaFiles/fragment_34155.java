@PersistenceContext
private EntityManager em;

@Resource
private AbstractPlatformTransactionManager transactionManager;

public void save(final Object obj) {
    new TransactionTemplate(transactionManager).execute(new TransactionCallbackWithoutResult() {
        @Override
        protected void doInTransactionWithoutResult(TransactionStatus status)
        {
            em.persist(obj);
        }
    });
}