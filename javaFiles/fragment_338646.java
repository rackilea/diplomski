@Override
@Cacheable(value = "main")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public Item findItemById(String id) {
    Item result = entityManager.find(Item.class, id);
    Hibernate.initialize(result.getAssociation1());
    Hibernate.initialize(result.getAssociation2());
    return result;
}