if (HibernateProxy.class.isInstance(entity.getConsumerEntity())) {
    HibernateProxy proxy = HibernateProxy.class.cast(entity.getConsumerEntity());
    if (proxy.getHibernateLazyInitializer().isUninitialized()) {
        // getConsumerEntity() IS NOT initialized
    } else {
        // getConsumerEntity() IS initialized
    }
}