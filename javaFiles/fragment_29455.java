protected <E extends BaseEntity> void delta(E newEntity) {

    // If the entity is null or has no ID, it hasn't been persisted before,
    // so there's no delta to calculate
    if ((newEntity == null) || (newEntity.getId() == null)) {
        return;
    }

    // Get the original entity
    @SuppressWarnings("unchecked")
    E oldEntity = (E) mongoDataStore.get(newEntity.getClass(), newEntity.getId()); 

    // Ensure that the old entity isn't null
    if (oldEntity == null) {
        LOG.error("Tried to compare and persist null objects - this is not allowed");
        return;
    }

    // Get the current user and ensure it is not null
    String email = ...;

    // Calculate the difference
    // We need to fetch the fields from the parent entity as well as they
    // are not automatically fetched
    Field[] fields = ArrayUtils.addAll(newEntity.getClass().getDeclaredFields(),
            BaseEntity.class.getDeclaredFields());
    Object oldField = null;
    Object newField = null;
    StringBuilder delta = new StringBuilder();
    for (Field field : fields) {
        field.setAccessible(true); // We need to access private fields
        try {
            oldField = field.get(oldEntity);
            newField = field.get(newEntity);
        } catch (IllegalArgumentException e) {
            LOG.error("Bad argument given");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOG.error("Could not access the argument");
            e.printStackTrace();
        }
        if ((oldField != newField)
                && (((oldField != null) && !oldField.equals(newField)) || ((newField != null) && !newField
                        .equals(oldField)))) {
            delta.append(field.getName()).append(": [").append(oldField).append("] -> [")
                    .append(newField).append("]  ");
        }
    }

    // Persist the difference
    if (delta.length() == 0) {
        LOG.warn("The delta is empty - this should not happen");
    } else {
        DeltaEntity deltaEntity = new DeltaEntity(oldEntity.getClass().toString(),
                oldEntity.getId(), oldEntity.getUuid(), email, delta.toString());
        mongoDataStore.save(deltaEntity);
    }
    return;
}