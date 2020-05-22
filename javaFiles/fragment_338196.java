public abstract class AbstractHibernateDAO<T> {

    private final Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public AbstractHibernateDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void saveCollection(Collection<T> entities) {
        for (T t: entities) {
            sessionFactory.getCurrentSession().save(t);
        }
    }

    // Other CRUD methods.

}