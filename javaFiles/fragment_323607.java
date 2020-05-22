public void moveToNextInterval(Class entity, javax.persistence.EntityManager em) throws IllegalAccessException, InstantiationException {
    javax.persistence.TableGenerator tableGenerator = null;
    for (Method method : entity.getMethods()) {
        tableGenerator = method.getAnnotation(javax.persistence.TableGenerator.class);
        if (tableGenerator != null) {
            break;
        }
    }
    if (tableGenerator != null && tableGenerator.allocationSize() > 1) {
        int allocationSize = tableGenerator.allocationSize();
        org.hibernate.impl.SessionImpl session = (org.hibernate.impl.SessionImpl) em.unwrap(org.hibernate.Session.class);
        IdentifierGenerator idGenerator = session.getFactory().getIdentifierGenerator(entity.getName());
        while ((Long)idGenerator.generate(session, entity.newInstance()) % allocationSize != allocationSize - 1);
    }
}