class BaseEntityManager<E> {
    private final Class<E> typeManaged;
    public Class<E> typeManaged() { return typeManaged; }
}

// remove duplicate class parameter
public <ENT extends BaseEntity> void update (BaseEntityManager<ENT> entityManager)