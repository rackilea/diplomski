@Transactional
public Comment createEntity(Entity entity) {
    entityManager.persist(comment);
    entityManager.flush();
    entityManager.refresh(comment);    

    return entity
}