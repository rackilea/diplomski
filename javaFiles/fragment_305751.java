public class GenericHibernateDAOImpl <T, ID extends Serializable> implements GenericDAO<T extends DataObject, ID extends Serializable> {
        ...

        GenericHibernateDAOImpl(Class<? extends T> persistentClass, ISessionManager manager,             IPersister persister, ILogger l) {
            Validate.noNullElements(Arrays.asList(manager, persister, l));
            this.pClass = persistentClass;
            this.sessionManager = manager;
            this.persistenceDelegate = persister;
            this.logger = l;

        }
        /**
         * {@inheritDoc}
         */
        @Override
        public final T save(final T entity) { 
            persistenceDelegate.save(entity);
            return entity;
        }

        public List<T> findFromCriterions(final Criterion... pCriterions) {
        final Criteria crit = sessionManager.getSession().createCriteria(pClass);
        for (Criterion criterion : pCriterions) {
            crit.add(criterion);
        }
        return crit.list();
    }

    }

public final class SimplePersister implements IPersister {

    private final ISessionManager sessionManager;

    public SimplePersister (final ISessionManager manager) {
        sessionManager = manager;
    }

    @Override
    public <T> void save(final T entity) {
        sessionManager.getSession().save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void delete(final T entity) {
        sessionManager.getSession().delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void update(final T entity) {
        sessionManager.getSession().saveOrUpdate(entity);
    }

}