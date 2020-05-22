@Override
public <E extends BaseEntity> ObjectId persist(E entity) {
    delta(entity);
    mongoDataStore.save(entity);
    return entity.getId();
}