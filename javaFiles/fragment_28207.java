@Stateless
public class JPABaseDAO<T> implements BaseDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityType;

    @SuppressWarnings("unchecked")
    public JPABaseDAO() {
        this.entityType = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T getByID(Long ID) {
        return entityManager.find(entityType, ID);
    }

    @Override  
    public T save(T type) {
        return entityManager.persist(type);        
    }

    @Override  
    public T update(T type) {        
        return entityManager.merge(type);
    }

    @Override
    public void delete(T type) {
        entityManager.remove(entityManager.contains(type) ? type : entityManager.merge(type));
    }

}