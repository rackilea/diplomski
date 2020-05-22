public abstract class GenericDao<E> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> clazz;

    protected GenericDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    public List<E> findAll(Integer start, Integer maxResult) {
        TypedQuery<E> query = em.createNamedQuery(clazz.getCanonicalName() + ".findAll", clazz);            
        query.setFirstResult(start);
        query.setMaxResults(maxResult);
        return query.getResultList();
    }
}