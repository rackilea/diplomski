public abstract class AbstractHibernateDAO<T> {
    private Class<T> persistentClass;

    public AbstractHibernateDAO() {
       this.persistentClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected T find(final Serializable id)
    {
        T ret = null;
        if (id != null)
        {
            ret = m_entityManager.find(persistentClass, id);
        }   // if
        return ret;
    }