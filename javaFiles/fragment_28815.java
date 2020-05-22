@Override
@Transactional
public void save(Entity entity) {
    entity = entityManager.merge(entity);
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(entity);
    session.flush();
}