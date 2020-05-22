public <E extends BaseEntity> ObjectId persist(E entity) {

  // If it's a user and doesn't yet have an ID, set one; start counting from 1000.
  if ((entity instanceof UserEntity) && (((UserEntity) entity).getUserId() == null)) {
    ((UserEntity) entity).setUserId(
      generateAutoIncrement(entity.getClass().getName(), 1000L));
  }

  // Additionally, set an ID within each user group; start counting from 1.
  if ((entity instanceof UserEntity) && (((UserEntity) entity).getRoleId() == null)) {
    ((UserEntity) entity).setRoleId(
      generateAutoIncrement(entity.getClass().getName() + "-" + entity.getRole(), 1L));
  }

  mongoDataStore.save(entity);
  return entity.getId();
}

/**
 * Return a unique numeric value for the given key.
 * The minimum value, set to 1 if nothing specific is required.
 */
protected long generateAutoIncrement(final String key, final long minimumValue){

  // Get the given key from the auto increment entity and try to increment it.
  final Query<AutoIncrementEntity> query = mongoDataStore.find(
        AutoIncrementEntity.class).field("_id").equal(key);
  final UpdateOperations<AutoIncrementEntity> update = mongoDataStore
        .createUpdateOperations(AutoIncrementEntity.class).inc("value");
  AutoIncrementEntity autoIncrement = mongoDataStore.findAndModify(query, update);

  // If none is found, we need to create one for the given key.
  if (autoIncrement == null) {
      autoIncrement = new AutoIncrementEntity(key, minimumValue);
      mongoDataStore.save(autoIncrement);
  }
  return autoIncrement.getValue();
}