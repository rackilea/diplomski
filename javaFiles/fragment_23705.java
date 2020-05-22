public Serializable getIdentifier(Object object) {

    if (!(object instanceof HibernateProxy) || Hibernate.isInitialized(object)) {
        return ((Persistent)object).getId();
    }

    HibernateProxy proxy = (HibernateProxy) object;
    LazyInitializer initializer = proxy.getHibernateLazyInitializer();
    return initializer.getIdentifier();
}