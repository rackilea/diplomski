public T unproxy(T proxied)
{
    T entity = proxied;
    if (entity instanceof HibernateProxy) {
        Hibernate.initialize(entity);
        entity = (T) ((HibernateProxy) entity)
                  .getHibernateLazyInitializer()
                  .getImplementation();
    }
    return entity;
}