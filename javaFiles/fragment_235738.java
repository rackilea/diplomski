public abstract class BaseDaoHibernate<T> extends HibernateDaoSupport implements Dao<T> {

    private final Class<T> entityType;

    protected BaseDaoHibernate(Class<T> entityType) {
        this.entityType = entityType;
    }

    public T get(long id) {
        return getHibernateTemplate().get(entityType, id);
    }

    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    public void remove(long id) {
        getHibernateTemplate().delete(get(id));
    }
}