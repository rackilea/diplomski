public abstract class AbstractDAO<E extends Serializable, 
                                 PK extends Serializable> {

    private final transient Class<E> entityClass;

    public AbstractDAO(final Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public final E find(final PK id) {
        return getEntityManager().find(entityClass, id);
    }

    // Another common methods

}